package io.realm;


public interface com_refresh_pos_domain_sale_SaleRealmProxyInterface {
    public int realmGet$id();
    public void realmSet$id(int value);
    public String realmGet$startTime();
    public void realmSet$startTime(String value);
    public String realmGet$endTime();
    public void realmSet$endTime(String value);
    public String realmGet$status();
    public void realmSet$status(String value);
    public Double realmGet$discount();
    public void realmSet$discount(Double value);
    public Double realmGet$total();
    public void realmSet$total(Double value);
    public Long realmGet$mobile();
    public void realmSet$mobile(Long value);
    public RealmList<com.refresh.pos.domain.inventory.LineItem> realmGet$items();
    public void realmSet$items(RealmList<com.refresh.pos.domain.inventory.LineItem> value);
}
