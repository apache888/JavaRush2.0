package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery{
    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        int count = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        for (File file : logDir.toFile().listFiles()) {
            ArrayList<String> data = new ArrayList<>();
            Map<String, String> ipDateMap = new HashMap<>();
            try (Scanner scanner = new Scanner(file.getAbsoluteFile())) {
                while (scanner.hasNext()) {
                    data.add(scanner.nextLine());
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            for (String test : data) {
                Pattern datePattern = Pattern.compile("(\\d{2}).(\\d{2}).(\\d{4})\\s(\\d+):(\\d+):(\\d+)");
                Matcher matcherDate = datePattern.matcher(test);
                Pattern ipPattern = Pattern.compile("(\\d+).(\\d+).(\\d+).(\\d+)");
                Matcher matcherIp = ipPattern.matcher(test);
                if (matcherIp.find() && matcherDate.find()) {
                    ipDateMap.put(matcherDate.group(), matcherIp.group());
                }
            }
            ArrayList<String> ips = new ArrayList<>();
            for (Map.Entry<String, String> entry : ipDateMap.entrySet()) {
                boolean flag = false;
                try {
                    Date date = formatter.parse(entry.getKey());
                    if (after == null && before != null) {
                        if ((date.before(before) || date.equals(before)) && !ips.contains(entry.getValue())) {
                            count++;
                            flag = true;
                        }
                    }
                    if (before == null && after != null) {
                        if ((date.after(after) || date.equals(after)) && !ips.contains(entry.getValue())) {
                            count++;
                            flag = true;
                        }
                    }
                    if (after == null && before == null && !ips.contains(entry.getValue())) {
                        count++;
                        flag = true;
                    }
                    if (after != null && before != null && !ips.contains(entry.getValue())) {
                        if ((date.after(after) && date.before(before)) || date.equals(after) || date.equals(before)) {
                            count++;
                            flag = true;
                        }
                    }
                }
                catch (ParseException e){
                    e.printStackTrace();
                }
                if (flag) ips.add(entry.getValue());
            }
        }
        return count;
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> uniqueIps = new HashSet<>();
        for (File file : logDir.toFile().listFiles()) {
            ArrayList<String> data = new ArrayList<>();
            Map<String, String> ipDateMap = new HashMap<>();
            try (Scanner scanner = new Scanner(file.getAbsoluteFile())) {
                while (scanner.hasNext()) data.add(scanner.nextLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            for (String test : data) {
                Pattern datePattern = Pattern.compile("(\\d{2}).(\\d{2}).(\\d{4})\\s(\\d+):(\\d+):(\\d+)");
                Matcher matcherDate = datePattern.matcher(test);
                Pattern ipPattern = Pattern.compile("(\\d+).(\\d+).(\\d+).(\\d+)");
                Matcher matcherIp = ipPattern.matcher(test);
                if (matcherIp.find() && matcherDate.find()) {
                    ipDateMap.put(matcherDate.group(), matcherIp.group());
                }
            }
            for (Map.Entry<String, String> entry : ipDateMap.entrySet()) {
                boolean flag = false;
                try {
                    Date date = formatter.parse(entry.getKey());
                    if (after == null && before != null){
                        if ((date.before(before) || date.equals(before)) && !uniqueIps.contains(entry.getValue())) {
                            flag = true;
                        }
                    }
                    if (before == null && after != null){
                        if ((date.after(after) || date.equals(after)) && !uniqueIps.contains(entry.getValue())) {
                            flag = true;
                        }
                    }
                    if (after == null && before == null && !uniqueIps.contains(entry.getValue())) {
                        flag = true;
                    }
                    if (after != null && before != null && !uniqueIps.contains(entry.getValue())) {
                        if ((date.after(after) && date.before(before)) || date.equals(after) || date.equals(before)) {
                            flag = true;
                        }
                    }
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
                if (flag) uniqueIps.add(entry.getValue());
            }
        }
        return uniqueIps;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> uniqueIps = new HashSet<>();
        Set<String> userWorkIps = new HashSet<>();
        for (File file : logDir.toFile().listFiles()) {
            ArrayList<String> data = new ArrayList<>();
            Map<String, String> dateIpMap = new HashMap<>();
            Map<String, String> dateNameMap = new HashMap<>();
            try (Scanner scanner = new Scanner(file.getAbsoluteFile())) {
                while (scanner.hasNext()) data.add(scanner.nextLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            for (String test : data) {
                Pattern datePattern = Pattern.compile("(\\d{2}).(\\d{2}).(\\d{4})\\s(\\d+):(\\d+):(\\d+)");
                Matcher matcherDate = datePattern.matcher(test);
                Pattern ipPattern = Pattern.compile("(\\d+).(\\d+).(\\d+).(\\d+)");
                Matcher matcherIp = ipPattern.matcher(test);
                Pattern namePattern = Pattern.compile("(\\D+\\s)+");
                Matcher matcherName = namePattern.matcher(test);
                if (matcherIp.find() && matcherDate.find() && matcherName.find()) {
                    dateIpMap.put(matcherDate.group(), matcherIp.group());
                    dateNameMap.put(matcherDate.group(), matcherName.group().trim());
                }
            }
            for (Map.Entry<String, String> entry : dateIpMap.entrySet()) {
                boolean flag = false;
                try {
                    Date date = formatter.parse(entry.getKey());
                    if (after == null && before == null && !uniqueIps.contains(entry.getValue())) {
                        if (dateNameMap.get(entry.getKey()).equals(user)) {
                            userWorkIps.add(entry.getValue());
                            flag = true;
                        }
                    }
                    if (after == null && before != null)
                        if ((date.before(before) || date.equals(before)) && !uniqueIps.contains(entry.getValue())) {
                            if (dateNameMap.get(entry.getKey()).equals(user)) {
                                userWorkIps.add(entry.getValue());
                                flag = true;
                            }
                        }
                    if (before == null && after != null)
                        if ((date.after(after) || date.equals(after)) && !uniqueIps.contains(entry.getValue())) {
                            if (dateNameMap.get(entry.getKey()).equals(user)) {
                                userWorkIps.add(entry.getValue());
                                flag = true;
                            }
                        }
                    if (after != null && before != null && !uniqueIps.contains(entry.getValue())) {
                        if ((date.after(after) && date.before(before)) || date.equals(after) || date.equals(before)) {
                            if (dateNameMap.get(entry.getKey()).equals(user)) {
                                userWorkIps.add(entry.getValue());
                                flag = true;
                            }
                        }
                    }
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
                if (flag) uniqueIps.add(entry.getValue());
            }
        }
        return userWorkIps;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> uniqueIps = new HashSet<>();
        Set<String> ipsForEvent = new HashSet<>();
        for (File file : logDir.toFile().listFiles()) {
            ArrayList<String> data = new ArrayList<>();
            Map<String, String> dateIpMap = new HashMap<>();
            Map<String, String> dateEventMap = new HashMap<>();
            try (Scanner scanner = new Scanner(file.getAbsoluteFile())) {
                while (scanner.hasNext()) data.add(scanner.nextLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            for (String test : data) {
                Pattern datePattern = Pattern.compile("(\\d{2}).(\\d{2}).(\\d{4})\\s(\\d+):(\\d+):(\\d+)");
                Matcher matcherDate = datePattern.matcher(test);
                Pattern ipPattern = Pattern.compile("(\\d+).(\\d+).(\\d+).(\\d+)");
                Matcher matcherIp = ipPattern.matcher(test);
                Pattern eventPatter = Pattern.compile("([A-Z]+)_?([A-Z]+)");
                Matcher matcherEvent = eventPatter.matcher(test);
                if (matcherIp.find() && matcherDate.find() && matcherEvent.find()) {
                    dateIpMap.put(matcherDate.group(), matcherIp.group());
                    dateEventMap.put(matcherDate.group(), matcherEvent.group());
                }
            }
            for (Map.Entry<String, String> entry : dateIpMap.entrySet()) {
                boolean flag = false;
                try {
                    Date date = formatter.parse(entry.getKey());
                    if (after == null && before != null)
                        if ((date.before(before) || date.equals(before)) && !uniqueIps.contains(entry.getValue())) {
                            if (dateEventMap.get(entry.getKey()).equals(event.name())) {
                                ipsForEvent.add(entry.getValue());
                                flag = true;
                            }
                        }
                    if (before == null && after != null)
                        if ((date.after(after) || date.equals(after)) && !uniqueIps.contains(entry.getValue())) {
                            if (dateEventMap.get(entry.getKey()).equals(event.name())) {
                                ipsForEvent.add(entry.getValue());
                                flag = true;
                            }
                        }
                    if (after == null && before == null && !uniqueIps.contains(entry.getValue())) {
                        if (dateEventMap.get(entry.getKey()).equals(event.name())) {
                            ipsForEvent.add(entry.getValue());
                            flag = true;
                        }
                    }
                    if (after != null && before != null && !uniqueIps.contains(entry.getValue())) {
                        if ((date.after(after) && date.before(before)) || date.equals(after) || date.equals(before)) {
                            if (dateEventMap.get(entry.getKey()).equals(event.name())) {
                                ipsForEvent.add(entry.getValue());
                                flag = true;
                            }
                        }
                    }
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
                if (flag) uniqueIps.add(entry.getValue());
            }
        }
        return ipsForEvent;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> ipsForStatus = new HashSet<>();
        for (File file : logDir.toFile().listFiles()) {
            ArrayList<String> data = new ArrayList<>();
            try (Scanner scanner = new Scanner(file.getAbsoluteFile())) {
                while (scanner.hasNext()) data.add(scanner.nextLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            for (String test : data) {
                Pattern datePattern = Pattern.compile("(\\d{2}).(\\d{2}).(\\d{4})\\s(\\d+):(\\d+):(\\d+)");
                Matcher matcherDate = datePattern.matcher(test);
                Pattern ipPattern = Pattern.compile("(\\d+).(\\d+).(\\d+).(\\d+)");
                Matcher matcherIp = ipPattern.matcher(test);
                if (matcherIp.find() && matcherDate.find()) {
                    String statusString = test.substring(test.length() - status.name().length());
                    try {
                        Date date = formatter.parse(matcherDate.group());
                        if (after == null && before != null) {
                            if (date.before(before) || date.equals(before)) {
                                if (statusString.equals(status.name())) {
                                    ipsForStatus.add(matcherIp.group());
                                }
                            }
                        }
                        if (before == null && after != null) {
                            if ((date.after(after) || date.equals(after))) {
                                if (statusString.equals(status.name())) {
                                    ipsForStatus.add(matcherIp.group());
                                }
                            }
                        }
                        if (after == null && before == null) {
                            if (statusString.equals(status.name())) {
                                ipsForStatus.add(matcherIp.group());
                            }
                        }
                        if (after != null && before != null) {
                            if ((date.after(after) && date.before(before)) || date.equals(after) || date.equals(before)) {
                                if (statusString.equals(status.name())) {
                                    ipsForStatus.add(matcherIp.group());
                                }
                            }
                        }
                    }
                    catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return ipsForStatus;
    }
}