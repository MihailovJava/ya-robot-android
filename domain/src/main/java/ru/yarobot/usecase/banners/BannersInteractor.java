package ru.yarobot.usecase.banners;

import java.util.ArrayList;
import java.util.List;

import ru.yarobot.entities.BannerPositionEntity;
import ru.yarobot.entities.model.Banner;
import ru.yarobot.entities.model.BannerInfo;
import ru.yarobot.entities.model.BannerPage;
import ru.yarobot.entities.model.Campaign;
import ru.yarobot.entities.model.Position;
import ru.yarobot.repositories.BannerRepository;
import ru.yarobot.usecase.BaseInteractor;
import rx.Observable;

/**
 * Created by Nixy on 16.05.2016.
 */
public class BannersInteractor extends BaseInteractor<List<Banner>> {

    private BannerRepository repository;


    public BannersInteractor(Observable.Transformer schedulersTransformer, BannerRepository repository) {
        super(schedulersTransformer);
        this.repository = repository;
    }

    public Observable<List<Banner>> getBanners(int campaignId){
        return applySchedulers(
          Observable.create(subscriber -> {
              try {
                  BannerPage entity = new BannerPage(new ArrayList<>());
                  repository.getBannersList(campaignId,0).subscribe(
                          bannerPage -> {
                              collectData(entity,bannerPage.getBanners());
                              for (int i = 1; i < bannerPage.getTotalPages() ; i++){
                                  repository.getBannersList(campaignId,i).subscribe(
                                          bannerInfoPage1 -> {
                                              try {
                                                  collectData(entity,bannerInfoPage1.getBanners());
                                              }catch (Exception e){
                                                  subscriber.onError(e);
                                              }
                                          }
                                  );
                              }
                              subscriber.onNext(entity.getBanners());
                          },
                          subscriber::onError
                  );
              } catch (Exception e){
                  subscriber.onError(e);
              }

          })
        );
    }


    private void collectData(BannerPage entity, List<Banner> banners){
        entity.getBanners().addAll(banners);
        for (Banner banner : banners) {
            repository.getBannerInfo(banner.getBannerId()).subscribe(
                    banner::setBannerInfo
            );
        }
    }
}
