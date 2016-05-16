package ru.yarobot.usecase.banners;

import java.util.List;

import ru.yarobot.entities.BannerPositionEntity;
import ru.yarobot.entities.model.BannerInfo;
import ru.yarobot.entities.model.Position;
import ru.yarobot.repositories.BannerRepository;
import ru.yarobot.usecase.BaseInteractor;
import rx.Observable;

/**
 * Created by Nixy on 16.05.2016.
 */
public class BannersInteractor extends BaseInteractor<BannerPositionEntity> {

    private BannerRepository repository;

    public BannersInteractor(Observable.Transformer schedulersTransformer, BannerRepository repository) {
        super(schedulersTransformer);
        this.repository = repository;
    }

    public Observable<BannerPositionEntity> getBannerPosition(){
        return applySchedulers(
          Observable.create(subscriber -> {
              try {
                  BannerPositionEntity entity = new BannerPositionEntity();
                  repository.getBannerInfo(0).subscribe(
                          bannerInfoPage -> {
                              collectData(entity,bannerInfoPage.getBanners());
                              for (int i = 1; i < bannerInfoPage.getTotalPages() ; i++){
                                  repository.getBannerInfo(i).subscribe(
                                          bannerInfoPage1 -> {
                                              try {
                                                  collectData(entity,bannerInfoPage1.getBanners());
                                              }catch (Exception e){
                                                  subscriber.onError(e);
                                              }
                                          }
                                  );
                              }
                              subscriber.onNext(entity);
                          },
                          subscriber::onError
                  );
              } catch (Exception e){
                  subscriber.onError(e);
              }

          })
        );
    }


    private void collectData(BannerPositionEntity entity, List<BannerInfo> banners){
        for (BannerInfo bannerInfo : banners){
            Position position = bannerInfo.getPosition();
            if(position == null){
                entity.incNotInSearch();
            }else {
                entity.incInSearch();
            }
        }
    }
}
