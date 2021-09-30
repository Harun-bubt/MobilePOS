package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.NativeContext;
import io.realm.internal.OsList;
import io.realm.internal.OsMap;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSet;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.core.NativeRealmAny;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy extends com.refresh.pos.domain.sale.QuickLoadSale
    implements RealmObjectProxy, com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface {

    static final class QuickLoadSaleColumnInfo extends ColumnInfo {
        long idColKey;
        long totalColKey;
        long ordersColKey;
        long mobileColKey;
        long discountColKey;
        long saleColKey;

        QuickLoadSaleColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("QuickLoadSale");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.totalColKey = addColumnDetails("total", "total", objectSchemaInfo);
            this.ordersColKey = addColumnDetails("orders", "orders", objectSchemaInfo);
            this.mobileColKey = addColumnDetails("mobile", "mobile", objectSchemaInfo);
            this.discountColKey = addColumnDetails("discount", "discount", objectSchemaInfo);
            this.saleColKey = addColumnDetails("sale", "sale", objectSchemaInfo);
        }

        QuickLoadSaleColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new QuickLoadSaleColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final QuickLoadSaleColumnInfo src = (QuickLoadSaleColumnInfo) rawSrc;
            final QuickLoadSaleColumnInfo dst = (QuickLoadSaleColumnInfo) rawDst;
            dst.idColKey = src.idColKey;
            dst.totalColKey = src.totalColKey;
            dst.ordersColKey = src.ordersColKey;
            dst.mobileColKey = src.mobileColKey;
            dst.discountColKey = src.discountColKey;
            dst.saleColKey = src.saleColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private QuickLoadSaleColumnInfo columnInfo;
    private ProxyState<com.refresh.pos.domain.sale.QuickLoadSale> proxyState;

    com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (QuickLoadSaleColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.refresh.pos.domain.sale.QuickLoadSale>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idColKey);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$total() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.totalColKey)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.totalColKey);
    }

    @Override
    public void realmSet$total(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.totalColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.totalColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.totalColKey);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.totalColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$orders() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.ordersColKey)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.ordersColKey);
    }

    @Override
    public void realmSet$orders(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ordersColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setLong(columnInfo.ordersColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ordersColKey);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.ordersColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Long realmGet$mobile() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.mobileColKey)) {
            return null;
        }
        return (long) proxyState.getRow$realm().getLong(columnInfo.mobileColKey);
    }

    @Override
    public void realmSet$mobile(Long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.mobileColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setLong(columnInfo.mobileColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mobileColKey);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.mobileColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$discount() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.discountColKey)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.discountColKey);
    }

    @Override
    public void realmSet$discount(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.discountColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.discountColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.discountColKey);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.discountColKey, value);
    }

    @Override
    public com.refresh.pos.domain.sale.Sale realmGet$sale() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.saleColKey)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.refresh.pos.domain.sale.Sale.class, proxyState.getRow$realm().getLink(columnInfo.saleColKey), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$sale(com.refresh.pos.domain.sale.Sale value) {
        Realm realm = (Realm) proxyState.getRealm$realm();
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("sale")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = realm.copyToRealmOrUpdate(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.saleColKey);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.saleColKey, row.getObjectKey(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.saleColKey);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.saleColKey, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "QuickLoadSale", false, 6, 0);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "total", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "orders", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "mobile", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "discount", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty(NO_ALIAS, "sale", RealmFieldType.OBJECT, "Sale");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static QuickLoadSaleColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new QuickLoadSaleColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "QuickLoadSale";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "QuickLoadSale";
    }

    @SuppressWarnings("cast")
    public static com.refresh.pos.domain.sale.QuickLoadSale createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.refresh.pos.domain.sale.QuickLoadSale obj = null;
        if (update) {
            Table table = realm.getTable(com.refresh.pos.domain.sale.QuickLoadSale.class);
            QuickLoadSaleColumnInfo columnInfo = (QuickLoadSaleColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.QuickLoadSale.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = Table.NO_MATCH;
            if (!json.isNull("id")) {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("id"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.QuickLoadSale.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("sale")) {
                excludeFields.add("sale");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy) realm.createObjectInternal(com.refresh.pos.domain.sale.QuickLoadSale.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy) realm.createObjectInternal(com.refresh.pos.domain.sale.QuickLoadSale.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface objProxy = (com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) obj;
        if (json.has("total")) {
            if (json.isNull("total")) {
                objProxy.realmSet$total(null);
            } else {
                objProxy.realmSet$total((double) json.getDouble("total"));
            }
        }
        if (json.has("orders")) {
            if (json.isNull("orders")) {
                objProxy.realmSet$orders(null);
            } else {
                objProxy.realmSet$orders((int) json.getInt("orders"));
            }
        }
        if (json.has("mobile")) {
            if (json.isNull("mobile")) {
                objProxy.realmSet$mobile(null);
            } else {
                objProxy.realmSet$mobile((long) json.getLong("mobile"));
            }
        }
        if (json.has("discount")) {
            if (json.isNull("discount")) {
                objProxy.realmSet$discount(null);
            } else {
                objProxy.realmSet$discount((double) json.getDouble("discount"));
            }
        }
        if (json.has("sale")) {
            if (json.isNull("sale")) {
                objProxy.realmSet$sale(null);
            } else {
                com.refresh.pos.domain.sale.Sale saleObj = com_refresh_pos_domain_sale_SaleRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("sale"), update);
                objProxy.realmSet$sale(saleObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.refresh.pos.domain.sale.QuickLoadSale createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.refresh.pos.domain.sale.QuickLoadSale obj = new com.refresh.pos.domain.sale.QuickLoadSale();
        final com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface objProxy = (com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("total")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$total((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$total(null);
                }
            } else if (name.equals("orders")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$orders((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$orders(null);
                }
            } else if (name.equals("mobile")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$mobile((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$mobile(null);
                }
            } else if (name.equals("discount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$discount((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$discount(null);
                }
            } else if (name.equals("sale")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$sale(null);
                } else {
                    com.refresh.pos.domain.sale.Sale saleObj = com_refresh_pos_domain_sale_SaleRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$sale(saleObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.QuickLoadSale.class), false, Collections.<String>emptyList());
        io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy obj = new io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.refresh.pos.domain.sale.QuickLoadSale copyOrUpdate(Realm realm, QuickLoadSaleColumnInfo columnInfo, com.refresh.pos.domain.sale.QuickLoadSale object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.refresh.pos.domain.sale.QuickLoadSale) cachedRealmObject;
        }

        com.refresh.pos.domain.sale.QuickLoadSale realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.refresh.pos.domain.sale.QuickLoadSale.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = table.findFirstLong(pkColumnKey, ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$id());
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.refresh.pos.domain.sale.QuickLoadSale copy(Realm realm, QuickLoadSaleColumnInfo columnInfo, com.refresh.pos.domain.sale.QuickLoadSale newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.refresh.pos.domain.sale.QuickLoadSale) cachedRealmObject;
        }

        com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface unmanagedSource = (com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) newObject;

        Table table = realm.getTable(com.refresh.pos.domain.sale.QuickLoadSale.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addDouble(columnInfo.totalColKey, unmanagedSource.realmGet$total());
        builder.addInteger(columnInfo.ordersColKey, unmanagedSource.realmGet$orders());
        builder.addInteger(columnInfo.mobileColKey, unmanagedSource.realmGet$mobile());
        builder.addDouble(columnInfo.discountColKey, unmanagedSource.realmGet$discount());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        com.refresh.pos.domain.sale.Sale saleObj = unmanagedSource.realmGet$sale();
        if (saleObj == null) {
            managedCopy.realmSet$sale(null);
        } else {
            com.refresh.pos.domain.sale.Sale cachesale = (com.refresh.pos.domain.sale.Sale) cache.get(saleObj);
            if (cachesale != null) {
                managedCopy.realmSet$sale(cachesale);
            } else {
                managedCopy.realmSet$sale(com_refresh_pos_domain_sale_SaleRealmProxy.copyOrUpdate(realm, (com_refresh_pos_domain_sale_SaleRealmProxy.SaleColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.Sale.class), saleObj, update, cache, flags));
            }
        }

        return managedCopy;
    }

    public static long insert(Realm realm, com.refresh.pos.domain.sale.QuickLoadSale object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.refresh.pos.domain.sale.QuickLoadSale.class);
        long tableNativePtr = table.getNativePtr();
        QuickLoadSaleColumnInfo columnInfo = (QuickLoadSaleColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.QuickLoadSale.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        Double realmGet$total = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$total();
        if (realmGet$total != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.totalColKey, objKey, realmGet$total, false);
        }
        Number realmGet$orders = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$orders();
        if (realmGet$orders != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.ordersColKey, objKey, realmGet$orders.longValue(), false);
        }
        Number realmGet$mobile = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$mobile();
        if (realmGet$mobile != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.mobileColKey, objKey, realmGet$mobile.longValue(), false);
        }
        Double realmGet$discount = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$discount();
        if (realmGet$discount != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.discountColKey, objKey, realmGet$discount, false);
        }

        com.refresh.pos.domain.sale.Sale saleObj = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$sale();
        if (saleObj != null) {
            Long cachesale = cache.get(saleObj);
            if (cachesale == null) {
                cachesale = com_refresh_pos_domain_sale_SaleRealmProxy.insert(realm, saleObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.saleColKey, objKey, cachesale, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.refresh.pos.domain.sale.QuickLoadSale.class);
        long tableNativePtr = table.getNativePtr();
        QuickLoadSaleColumnInfo columnInfo = (QuickLoadSaleColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.QuickLoadSale.class);
        long pkColumnKey = columnInfo.idColKey;
        com.refresh.pos.domain.sale.QuickLoadSale object = null;
        while (objects.hasNext()) {
            object = (com.refresh.pos.domain.sale.QuickLoadSale) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            Double realmGet$total = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$total();
            if (realmGet$total != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.totalColKey, objKey, realmGet$total, false);
            }
            Number realmGet$orders = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$orders();
            if (realmGet$orders != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.ordersColKey, objKey, realmGet$orders.longValue(), false);
            }
            Number realmGet$mobile = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$mobile();
            if (realmGet$mobile != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.mobileColKey, objKey, realmGet$mobile.longValue(), false);
            }
            Double realmGet$discount = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$discount();
            if (realmGet$discount != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.discountColKey, objKey, realmGet$discount, false);
            }

            com.refresh.pos.domain.sale.Sale saleObj = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$sale();
            if (saleObj != null) {
                Long cachesale = cache.get(saleObj);
                if (cachesale == null) {
                    cachesale = com_refresh_pos_domain_sale_SaleRealmProxy.insert(realm, saleObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.saleColKey, objKey, cachesale, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.refresh.pos.domain.sale.QuickLoadSale object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.refresh.pos.domain.sale.QuickLoadSale.class);
        long tableNativePtr = table.getNativePtr();
        QuickLoadSaleColumnInfo columnInfo = (QuickLoadSaleColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.QuickLoadSale.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, objKey);
        Double realmGet$total = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$total();
        if (realmGet$total != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.totalColKey, objKey, realmGet$total, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalColKey, objKey, false);
        }
        Number realmGet$orders = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$orders();
        if (realmGet$orders != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.ordersColKey, objKey, realmGet$orders.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ordersColKey, objKey, false);
        }
        Number realmGet$mobile = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$mobile();
        if (realmGet$mobile != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.mobileColKey, objKey, realmGet$mobile.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mobileColKey, objKey, false);
        }
        Double realmGet$discount = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$discount();
        if (realmGet$discount != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.discountColKey, objKey, realmGet$discount, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.discountColKey, objKey, false);
        }

        com.refresh.pos.domain.sale.Sale saleObj = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$sale();
        if (saleObj != null) {
            Long cachesale = cache.get(saleObj);
            if (cachesale == null) {
                cachesale = com_refresh_pos_domain_sale_SaleRealmProxy.insertOrUpdate(realm, saleObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.saleColKey, objKey, cachesale, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.saleColKey, objKey);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.refresh.pos.domain.sale.QuickLoadSale.class);
        long tableNativePtr = table.getNativePtr();
        QuickLoadSaleColumnInfo columnInfo = (QuickLoadSaleColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.QuickLoadSale.class);
        long pkColumnKey = columnInfo.idColKey;
        com.refresh.pos.domain.sale.QuickLoadSale object = null;
        while (objects.hasNext()) {
            object = (com.refresh.pos.domain.sale.QuickLoadSale) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, objKey);
            Double realmGet$total = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$total();
            if (realmGet$total != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.totalColKey, objKey, realmGet$total, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.totalColKey, objKey, false);
            }
            Number realmGet$orders = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$orders();
            if (realmGet$orders != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.ordersColKey, objKey, realmGet$orders.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ordersColKey, objKey, false);
            }
            Number realmGet$mobile = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$mobile();
            if (realmGet$mobile != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.mobileColKey, objKey, realmGet$mobile.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.mobileColKey, objKey, false);
            }
            Double realmGet$discount = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$discount();
            if (realmGet$discount != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.discountColKey, objKey, realmGet$discount, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.discountColKey, objKey, false);
            }

            com.refresh.pos.domain.sale.Sale saleObj = ((com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) object).realmGet$sale();
            if (saleObj != null) {
                Long cachesale = cache.get(saleObj);
                if (cachesale == null) {
                    cachesale = com_refresh_pos_domain_sale_SaleRealmProxy.insertOrUpdate(realm, saleObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.saleColKey, objKey, cachesale, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.saleColKey, objKey);
            }
        }
    }

    public static com.refresh.pos.domain.sale.QuickLoadSale createDetachedCopy(com.refresh.pos.domain.sale.QuickLoadSale realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.refresh.pos.domain.sale.QuickLoadSale unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.refresh.pos.domain.sale.QuickLoadSale();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.refresh.pos.domain.sale.QuickLoadSale) cachedObject.object;
            }
            unmanagedObject = (com.refresh.pos.domain.sale.QuickLoadSale) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface unmanagedCopy = (com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) unmanagedObject;
        com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface realmSource = (com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$total(realmSource.realmGet$total());
        unmanagedCopy.realmSet$orders(realmSource.realmGet$orders());
        unmanagedCopy.realmSet$mobile(realmSource.realmGet$mobile());
        unmanagedCopy.realmSet$discount(realmSource.realmGet$discount());

        // Deep copy of sale
        unmanagedCopy.realmSet$sale(com_refresh_pos_domain_sale_SaleRealmProxy.createDetachedCopy(realmSource.realmGet$sale(), currentDepth + 1, maxDepth, cache));

        return unmanagedObject;
    }

    static com.refresh.pos.domain.sale.QuickLoadSale update(Realm realm, QuickLoadSaleColumnInfo columnInfo, com.refresh.pos.domain.sale.QuickLoadSale realmObject, com.refresh.pos.domain.sale.QuickLoadSale newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface realmObjectTarget = (com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) realmObject;
        com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface realmObjectSource = (com_refresh_pos_domain_sale_QuickLoadSaleRealmProxyInterface) newObject;
        Table table = realm.getTable(com.refresh.pos.domain.sale.QuickLoadSale.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addDouble(columnInfo.totalColKey, realmObjectSource.realmGet$total());
        builder.addInteger(columnInfo.ordersColKey, realmObjectSource.realmGet$orders());
        builder.addInteger(columnInfo.mobileColKey, realmObjectSource.realmGet$mobile());
        builder.addDouble(columnInfo.discountColKey, realmObjectSource.realmGet$discount());

        com.refresh.pos.domain.sale.Sale saleObj = realmObjectSource.realmGet$sale();
        if (saleObj == null) {
            builder.addNull(columnInfo.saleColKey);
        } else {
            com.refresh.pos.domain.sale.Sale cachesale = (com.refresh.pos.domain.sale.Sale) cache.get(saleObj);
            if (cachesale != null) {
                builder.addObject(columnInfo.saleColKey, cachesale);
            } else {
                builder.addObject(columnInfo.saleColKey, com_refresh_pos_domain_sale_SaleRealmProxy.copyOrUpdate(realm, (com_refresh_pos_domain_sale_SaleRealmProxy.SaleColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.Sale.class), saleObj, true, cache, flags));
            }
        }

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("QuickLoadSale = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{total:");
        stringBuilder.append(realmGet$total() != null ? realmGet$total() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{orders:");
        stringBuilder.append(realmGet$orders() != null ? realmGet$orders() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mobile:");
        stringBuilder.append(realmGet$mobile() != null ? realmGet$mobile() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{discount:");
        stringBuilder.append(realmGet$discount() != null ? realmGet$discount() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sale:");
        stringBuilder.append(realmGet$sale() != null ? "Sale" : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long objKey = proxyState.getRow$realm().getObjectKey();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (objKey ^ (objKey >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy aQuickLoadSale = (com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aQuickLoadSale.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aQuickLoadSale.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aQuickLoadSale.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
