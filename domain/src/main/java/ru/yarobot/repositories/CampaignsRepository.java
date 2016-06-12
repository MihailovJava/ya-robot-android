package ru.yarobot.repositories;

import ru.yarobot.entities.model.CampaignInfo;
import ru.yarobot.entities.model.CampaignPage;
import rx.Observable;

/**
 * Created by Nixy on 04.06.2016.
 */
public interface CampaignsRepository {
    Observable<CampaignPage> getCampaignsList(int page);

    Observable<CampaignInfo> getCampaignsInfo(int id);
}
