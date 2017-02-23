package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;   //время выполнения заказа поваром

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException{
        List<Advertisement> availableVideos = storage.list();
//        List<Advertisement> showVideos = new ArrayList<>();
//        int totalTime = 0;
//        for (Advertisement video : availableVideos) {
//            if (video.getDuration() < timeSeconds) {
//                if ((totalTime + video.getDuration()) < timeSeconds){
//                    totalTime =  totalTime + video.getDuration();
//                    showVideos.add(video);
//                }else totalTime =  totalTime;
//            }
//        }
        if (availableVideos.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        Collections.sort(availableVideos, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                long pricePerVideoDiff = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
                if (pricePerVideoDiff != 0) {
                    return (int) pricePerVideoDiff;
                }else{
                    return (int)(o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration() - o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
                }
            }
        });
//        int totalTime = timeSeconds;
        for (Advertisement adVideo : availableVideos) {
//            if (adVideo.getDuration() <= totalTime && adVideo.getHits() > 0) {

                ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", adVideo.getName(),
                        adVideo.getAmountPerOneDisplaying(), adVideo.getAmountPerOneDisplaying() * 1000 / adVideo.getDuration()));
                adVideo.revalidate();
//                totalTime -= adVideo.getDuration();
//            }
        }
    }
}
