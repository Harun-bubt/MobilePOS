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
public class com_refresh_pos_domain_sale_SaleRealmProxy extends com.refresh.pos.domain.sale.Sale
    implements RealmObjectProxy, com_refresh_pos_domain_sale_SaleRealmProxyInterface {

    static final class SaleColumnInfo extends ColumnInfo {
        long idColKey;
        long startTimeColKey;
        long endTimeColKey;
        long statusColKey;
        long discountColKey;
        long totalColKey;
        long mobileColKey;
        long itemsColKey;

        SaleColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Sale");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.startTimeColKey = addColumnDetails("startTime", "startTime", objectSchemaInfo);
            this.endTimeColKey = addColumnDetails("endTime", "endTime", objectSchemaInfo);
            this.statusColKey = addColumnDetails("status", "status", objectSchemaInfo);
            this.discountColKey = addColumnDetails("discount", "discount", objectSchemaInfo);
            this.totalColKey = addColumnDetails("total", "total", objectSchemaInfo);
            this.mobileColKey = addColumnDetails("mobile", "mobile", objectSchemaInfo);
            this.itemsColKey = addColumnDetails("items", "items", objectSchemaInfo);
        }

        SaleColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new SaleColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final SaleColumnInfo src = (SaleColumnInfo) rawSrc;
            final SaleColumnInfo dst = (SaleColumnInfo) rawDst;
            dst.idColKey = src.idColKey;
            dst.startTimeColKey = src.startTimeColKey;
            dst.endTimeColKey = src.endTimeColKey;
            dst.statusColKey = src.statusColKey;
            dst.discountColKey = src.discountColKey;
            dst.totalColKey = src.totalColKey;
            dst.mobileColKey = src.mobileColKey;
            dst.itemsColKey = src.itemsColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private SaleColumnInfo columnInfo;
    private ProxyState<com.refresh.pos.domain.sale.Sale> proxyState;
    private RealmList<com.refresh.pos.domain.inventory.LineItem> itemsRealmList;

    com_refresh_pos_domain_sale_SaleRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SaleColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.refresh.pos.domain.sale.Sale>(this);
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
    public String realmGet$startTime() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.startTimeColKey);
    }

    @Override
    public void realmSet$startTime(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.startTimeColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.startTimeColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.startTimeColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.startTimeColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$endTime() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.endTimeColKey);
    }

    @Override
    public void realmSet$endTime(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.endTimeColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.endTimeColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.endTimeColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.endTimeColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusColKey);
    }

    @Override
    public void realmSet$status(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.statusColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusColKey, value);
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
    public RealmList<com.refresh.pos.domain.inventory.LineItem> realmGet$items() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (itemsRealmList != null) {
            return itemsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.itemsColKey);
            itemsRealmList = new RealmList<com.refresh.pos.domain.inventory.LineItem>(com.refresh.pos.domain.inventory.LineItem.class, osList, proxyState.getRealm$realm());
            return itemsRealmList;
        }
    }

    @Override
    public void realmSet$items(RealmList<com.refresh.pos.domain.inventory.LineItem> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("items")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.refresh.pos.domain.inventory.LineItem> original = value;
                value = new RealmList<com.refresh.pos.domain.inventory.LineItem>();
                for (com.refresh.pos.domain.inventory.LineItem item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealmOrUpdate(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.itemsColKey);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.refresh.pos.domain.inventory.LineItem linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getObjectKey());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.refresh.pos.domain.inventory.LineItem linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getObjectKey());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Sale", false, 8, 0);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "startTime", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "endTime", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "discount", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "total", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "mobile", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty(NO_ALIAS, "items", RealmFieldType.LIST, "LineItem");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static SaleColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new SaleColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Sale";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Sale";
    }

    @SuppressWarnings("cast")
    public static com.refresh.pos.domain.sale.Sale createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.refresh.pos.domain.sale.Sale obj = null;
        if (update) {
            Table table = realm.getTable(com.refresh.pos.domain.sale.Sale.class);
            SaleColumnInfo columnInfo = (SaleColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.Sale.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = Table.NO_MATCH;
            if (!json.isNull("id")) {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("id"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.Sale.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_refresh_pos_domain_sale_SaleRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("items")) {
                excludeFields.add("items");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_refresh_pos_domain_sale_SaleRealmProxy) realm.createObjectInternal(com.refresh.pos.domain.sale.Sale.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_refresh_pos_domain_sale_SaleRealmProxy) realm.createObjectInternal(com.refresh.pos.domain.sale.Sale.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_refresh_pos_domain_sale_SaleRealmProxyInterface objProxy = (com_refresh_pos_domain_sale_SaleRealmProxyInterface) obj;
        if (json.has("startTime")) {
            if (json.isNull("startTime")) {
                objProxy.realmSet$startTime(null);
            } else {
                objProxy.realmSet$startTime((String) json.getString("startTime"));
            }
        }
        if (json.has("endTime")) {
            if (json.isNull("endTime")) {
                objProxy.realmSet$endTime(null);
            } else {
                objProxy.realmSet$endTime((String) json.getString("endTime"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                objProxy.realmSet$status(null);
            } else {
                objProxy.realmSet$status((String) json.getString("status"));
            }
        }
        if (json.has("discount")) {
            if (json.isNull("discount")) {
                objProxy.realmSet$discount(null);
            } else {
                objProxy.realmSet$discount((double) json.getDouble("discount"));
            }
        }
        if (json.has("total")) {
            if (json.isNull("total")) {
                objProxy.realmSet$total(null);
            } else {
                objProxy.realmSet$total((double) json.getDouble("total"));
            }
        }
        if (json.has("mobile")) {
            if (json.isNull("mobile")) {
                objProxy.realmSet$mobile(null);
            } else {
                objProxy.realmSet$mobile((long) json.getLong("mobile"));
            }
        }
        if (json.has("items")) {
            if (json.isNull("items")) {
                objProxy.realmSet$items(null);
            } else {
                objProxy.realmGet$items().clear();
                JSONArray array = json.getJSONArray("items");
                for (int i = 0; i < array.length(); i++) {
                    com.refresh.pos.domain.inventory.LineItem item = com_refresh_pos_domain_inventory_LineItemRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$items().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.refresh.pos.domain.sale.Sale createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.refresh.pos.domain.sale.Sale obj = new com.refresh.pos.domain.sale.Sale();
        final com_refresh_pos_domain_sale_SaleRealmProxyInterface objProxy = (com_refresh_pos_domain_sale_SaleRealmProxyInterface) obj;
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
            } else if (name.equals("startTime")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$startTime((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$startTime(null);
                }
            } else if (name.equals("endTime")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$endTime((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$endTime(null);
                }
            } else if (name.equals("status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$status(null);
                }
            } else if (name.equals("discount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$discount((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$discount(null);
                }
            } else if (name.equals("total")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$total((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$total(null);
                }
            } else if (name.equals("mobile")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$mobile((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$mobile(null);
                }
            } else if (name.equals("items")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$items(null);
                } else {
                    objProxy.realmSet$items(new RealmList<com.refresh.pos.domain.inventory.LineItem>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.refresh.pos.domain.inventory.LineItem item = com_refresh_pos_domain_inventory_LineItemRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$items().add(item);
                    }
                    reader.endArray();
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

    static com_refresh_pos_domain_sale_SaleRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.Sale.class), false, Collections.<String>emptyList());
        io.realm.com_refresh_pos_domain_sale_SaleRealmProxy obj = new io.realm.com_refresh_pos_domain_sale_SaleRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.refresh.pos.domain.sale.Sale copyOrUpdate(Realm realm, SaleColumnInfo columnInfo, com.refresh.pos.domain.sale.Sale object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.refresh.pos.domain.sale.Sale) cachedRealmObject;
        }

        com.refresh.pos.domain.sale.Sale realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.refresh.pos.domain.sale.Sale.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = table.findFirstLong(pkColumnKey, ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$id());
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_refresh_pos_domain_sale_SaleRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.refresh.pos.domain.sale.Sale copy(Realm realm, SaleColumnInfo columnInfo, com.refresh.pos.domain.sale.Sale newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.refresh.pos.domain.sale.Sale) cachedRealmObject;
        }

        com_refresh_pos_domain_sale_SaleRealmProxyInterface unmanagedSource = (com_refresh_pos_domain_sale_SaleRealmProxyInterface) newObject;

        Table table = realm.getTable(com.refresh.pos.domain.sale.Sale.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addString(columnInfo.startTimeColKey, unmanagedSource.realmGet$startTime());
        builder.addString(columnInfo.endTimeColKey, unmanagedSource.realmGet$endTime());
        builder.addString(columnInfo.statusColKey, unmanagedSource.realmGet$status());
        builder.addDouble(columnInfo.discountColKey, unmanagedSource.realmGet$discount());
        builder.addDouble(columnInfo.totalColKey, unmanagedSource.realmGet$total());
        builder.addInteger(columnInfo.mobileColKey, unmanagedSource.realmGet$mobile());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_refresh_pos_domain_sale_SaleRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        RealmList<com.refresh.pos.domain.inventory.LineItem> itemsUnmanagedList = unmanagedSource.realmGet$items();
        if (itemsUnmanagedList != null) {
            RealmList<com.refresh.pos.domain.inventory.LineItem> itemsManagedList = managedCopy.realmGet$items();
            itemsManagedList.clear();
            for (int i = 0; i < itemsUnmanagedList.size(); i++) {
                com.refresh.pos.domain.inventory.LineItem itemsUnmanagedItem = itemsUnmanagedList.get(i);
                com.refresh.pos.domain.inventory.LineItem cacheitems = (com.refresh.pos.domain.inventory.LineItem) cache.get(itemsUnmanagedItem);
                if (cacheitems != null) {
                    itemsManagedList.add(cacheitems);
                } else {
                    itemsManagedList.add(com_refresh_pos_domain_inventory_LineItemRealmProxy.copyOrUpdate(realm, (com_refresh_pos_domain_inventory_LineItemRealmProxy.LineItemColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.LineItem.class), itemsUnmanagedItem, update, cache, flags));
                }
            }
        }

        return managedCopy;
    }

    public static long insert(Realm realm, com.refresh.pos.domain.sale.Sale object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.refresh.pos.domain.sale.Sale.class);
        long tableNativePtr = table.getNativePtr();
        SaleColumnInfo columnInfo = (SaleColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.Sale.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$startTime = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$startTime();
        if (realmGet$startTime != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.startTimeColKey, objKey, realmGet$startTime, false);
        }
        String realmGet$endTime = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$endTime();
        if (realmGet$endTime != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.endTimeColKey, objKey, realmGet$endTime, false);
        }
        String realmGet$status = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, objKey, realmGet$status, false);
        }
        Double realmGet$discount = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$discount();
        if (realmGet$discount != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.discountColKey, objKey, realmGet$discount, false);
        }
        Double realmGet$total = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$total();
        if (realmGet$total != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.totalColKey, objKey, realmGet$total, false);
        }
        Number realmGet$mobile = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$mobile();
        if (realmGet$mobile != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.mobileColKey, objKey, realmGet$mobile.longValue(), false);
        }

        RealmList<com.refresh.pos.domain.inventory.LineItem> itemsList = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$items();
        if (itemsList != null) {
            OsList itemsOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.itemsColKey);
            for (com.refresh.pos.domain.inventory.LineItem itemsItem : itemsList) {
                Long cacheItemIndexitems = cache.get(itemsItem);
                if (cacheItemIndexitems == null) {
                    cacheItemIndexitems = com_refresh_pos_domain_inventory_LineItemRealmProxy.insert(realm, itemsItem, cache);
                }
                itemsOsList.addRow(cacheItemIndexitems);
            }
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.refresh.pos.domain.sale.Sale.class);
        long tableNativePtr = table.getNativePtr();
        SaleColumnInfo columnInfo = (SaleColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.Sale.class);
        long pkColumnKey = columnInfo.idColKey;
        com.refresh.pos.domain.sale.Sale object = null;
        while (objects.hasNext()) {
            object = (com.refresh.pos.domain.sale.Sale) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$startTime = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$startTime();
            if (realmGet$startTime != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.startTimeColKey, objKey, realmGet$startTime, false);
            }
            String realmGet$endTime = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$endTime();
            if (realmGet$endTime != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.endTimeColKey, objKey, realmGet$endTime, false);
            }
            String realmGet$status = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, objKey, realmGet$status, false);
            }
            Double realmGet$discount = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$discount();
            if (realmGet$discount != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.discountColKey, objKey, realmGet$discount, false);
            }
            Double realmGet$total = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$total();
            if (realmGet$total != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.totalColKey, objKey, realmGet$total, false);
            }
            Number realmGet$mobile = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$mobile();
            if (realmGet$mobile != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.mobileColKey, objKey, realmGet$mobile.longValue(), false);
            }

            RealmList<com.refresh.pos.domain.inventory.LineItem> itemsList = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$items();
            if (itemsList != null) {
                OsList itemsOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.itemsColKey);
                for (com.refresh.pos.domain.inventory.LineItem itemsItem : itemsList) {
                    Long cacheItemIndexitems = cache.get(itemsItem);
                    if (cacheItemIndexitems == null) {
                        cacheItemIndexitems = com_refresh_pos_domain_inventory_LineItemRealmProxy.insert(realm, itemsItem, cache);
                    }
                    itemsOsList.addRow(cacheItemIndexitems);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.refresh.pos.domain.sale.Sale object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.refresh.pos.domain.sale.Sale.class);
        long tableNativePtr = table.getNativePtr();
        SaleColumnInfo columnInfo = (SaleColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.Sale.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, objKey);
        String realmGet$startTime = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$startTime();
        if (realmGet$startTime != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.startTimeColKey, objKey, realmGet$startTime, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.startTimeColKey, objKey, false);
        }
        String realmGet$endTime = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$endTime();
        if (realmGet$endTime != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.endTimeColKey, objKey, realmGet$endTime, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.endTimeColKey, objKey, false);
        }
        String realmGet$status = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, objKey, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusColKey, objKey, false);
        }
        Double realmGet$discount = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$discount();
        if (realmGet$discount != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.discountColKey, objKey, realmGet$discount, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.discountColKey, objKey, false);
        }
        Double realmGet$total = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$total();
        if (realmGet$total != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.totalColKey, objKey, realmGet$total, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalColKey, objKey, false);
        }
        Number realmGet$mobile = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$mobile();
        if (realmGet$mobile != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.mobileColKey, objKey, realmGet$mobile.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mobileColKey, objKey, false);
        }

        OsList itemsOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.itemsColKey);
        RealmList<com.refresh.pos.domain.inventory.LineItem> itemsList = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$items();
        if (itemsList != null && itemsList.size() == itemsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objectCount = itemsList.size();
            for (int i = 0; i < objectCount; i++) {
                com.refresh.pos.domain.inventory.LineItem itemsItem = itemsList.get(i);
                Long cacheItemIndexitems = cache.get(itemsItem);
                if (cacheItemIndexitems == null) {
                    cacheItemIndexitems = com_refresh_pos_domain_inventory_LineItemRealmProxy.insertOrUpdate(realm, itemsItem, cache);
                }
                itemsOsList.setRow(i, cacheItemIndexitems);
            }
        } else {
            itemsOsList.removeAll();
            if (itemsList != null) {
                for (com.refresh.pos.domain.inventory.LineItem itemsItem : itemsList) {
                    Long cacheItemIndexitems = cache.get(itemsItem);
                    if (cacheItemIndexitems == null) {
                        cacheItemIndexitems = com_refresh_pos_domain_inventory_LineItemRealmProxy.insertOrUpdate(realm, itemsItem, cache);
                    }
                    itemsOsList.addRow(cacheItemIndexitems);
                }
            }
        }

        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.refresh.pos.domain.sale.Sale.class);
        long tableNativePtr = table.getNativePtr();
        SaleColumnInfo columnInfo = (SaleColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.Sale.class);
        long pkColumnKey = columnInfo.idColKey;
        com.refresh.pos.domain.sale.Sale object = null;
        while (objects.hasNext()) {
            object = (com.refresh.pos.domain.sale.Sale) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, objKey);
            String realmGet$startTime = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$startTime();
            if (realmGet$startTime != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.startTimeColKey, objKey, realmGet$startTime, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.startTimeColKey, objKey, false);
            }
            String realmGet$endTime = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$endTime();
            if (realmGet$endTime != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.endTimeColKey, objKey, realmGet$endTime, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.endTimeColKey, objKey, false);
            }
            String realmGet$status = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, objKey, realmGet$status, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.statusColKey, objKey, false);
            }
            Double realmGet$discount = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$discount();
            if (realmGet$discount != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.discountColKey, objKey, realmGet$discount, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.discountColKey, objKey, false);
            }
            Double realmGet$total = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$total();
            if (realmGet$total != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.totalColKey, objKey, realmGet$total, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.totalColKey, objKey, false);
            }
            Number realmGet$mobile = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$mobile();
            if (realmGet$mobile != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.mobileColKey, objKey, realmGet$mobile.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.mobileColKey, objKey, false);
            }

            OsList itemsOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.itemsColKey);
            RealmList<com.refresh.pos.domain.inventory.LineItem> itemsList = ((com_refresh_pos_domain_sale_SaleRealmProxyInterface) object).realmGet$items();
            if (itemsList != null && itemsList.size() == itemsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = itemsList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.refresh.pos.domain.inventory.LineItem itemsItem = itemsList.get(i);
                    Long cacheItemIndexitems = cache.get(itemsItem);
                    if (cacheItemIndexitems == null) {
                        cacheItemIndexitems = com_refresh_pos_domain_inventory_LineItemRealmProxy.insertOrUpdate(realm, itemsItem, cache);
                    }
                    itemsOsList.setRow(i, cacheItemIndexitems);
                }
            } else {
                itemsOsList.removeAll();
                if (itemsList != null) {
                    for (com.refresh.pos.domain.inventory.LineItem itemsItem : itemsList) {
                        Long cacheItemIndexitems = cache.get(itemsItem);
                        if (cacheItemIndexitems == null) {
                            cacheItemIndexitems = com_refresh_pos_domain_inventory_LineItemRealmProxy.insertOrUpdate(realm, itemsItem, cache);
                        }
                        itemsOsList.addRow(cacheItemIndexitems);
                    }
                }
            }

        }
    }

    public static com.refresh.pos.domain.sale.Sale createDetachedCopy(com.refresh.pos.domain.sale.Sale realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.refresh.pos.domain.sale.Sale unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.refresh.pos.domain.sale.Sale();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.refresh.pos.domain.sale.Sale) cachedObject.object;
            }
            unmanagedObject = (com.refresh.pos.domain.sale.Sale) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_refresh_pos_domain_sale_SaleRealmProxyInterface unmanagedCopy = (com_refresh_pos_domain_sale_SaleRealmProxyInterface) unmanagedObject;
        com_refresh_pos_domain_sale_SaleRealmProxyInterface realmSource = (com_refresh_pos_domain_sale_SaleRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$startTime(realmSource.realmGet$startTime());
        unmanagedCopy.realmSet$endTime(realmSource.realmGet$endTime());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$discount(realmSource.realmGet$discount());
        unmanagedCopy.realmSet$total(realmSource.realmGet$total());
        unmanagedCopy.realmSet$mobile(realmSource.realmGet$mobile());

        // Deep copy of items
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$items(null);
        } else {
            RealmList<com.refresh.pos.domain.inventory.LineItem> manageditemsList = realmSource.realmGet$items();
            RealmList<com.refresh.pos.domain.inventory.LineItem> unmanageditemsList = new RealmList<com.refresh.pos.domain.inventory.LineItem>();
            unmanagedCopy.realmSet$items(unmanageditemsList);
            int nextDepth = currentDepth + 1;
            int size = manageditemsList.size();
            for (int i = 0; i < size; i++) {
                com.refresh.pos.domain.inventory.LineItem item = com_refresh_pos_domain_inventory_LineItemRealmProxy.createDetachedCopy(manageditemsList.get(i), nextDepth, maxDepth, cache);
                unmanageditemsList.add(item);
            }
        }

        return unmanagedObject;
    }

    static com.refresh.pos.domain.sale.Sale update(Realm realm, SaleColumnInfo columnInfo, com.refresh.pos.domain.sale.Sale realmObject, com.refresh.pos.domain.sale.Sale newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_refresh_pos_domain_sale_SaleRealmProxyInterface realmObjectTarget = (com_refresh_pos_domain_sale_SaleRealmProxyInterface) realmObject;
        com_refresh_pos_domain_sale_SaleRealmProxyInterface realmObjectSource = (com_refresh_pos_domain_sale_SaleRealmProxyInterface) newObject;
        Table table = realm.getTable(com.refresh.pos.domain.sale.Sale.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.startTimeColKey, realmObjectSource.realmGet$startTime());
        builder.addString(columnInfo.endTimeColKey, realmObjectSource.realmGet$endTime());
        builder.addString(columnInfo.statusColKey, realmObjectSource.realmGet$status());
        builder.addDouble(columnInfo.discountColKey, realmObjectSource.realmGet$discount());
        builder.addDouble(columnInfo.totalColKey, realmObjectSource.realmGet$total());
        builder.addInteger(columnInfo.mobileColKey, realmObjectSource.realmGet$mobile());

        RealmList<com.refresh.pos.domain.inventory.LineItem> itemsUnmanagedList = realmObjectSource.realmGet$items();
        if (itemsUnmanagedList != null) {
            RealmList<com.refresh.pos.domain.inventory.LineItem> itemsManagedCopy = new RealmList<com.refresh.pos.domain.inventory.LineItem>();
            for (int i = 0; i < itemsUnmanagedList.size(); i++) {
                com.refresh.pos.domain.inventory.LineItem itemsItem = itemsUnmanagedList.get(i);
                com.refresh.pos.domain.inventory.LineItem cacheitems = (com.refresh.pos.domain.inventory.LineItem) cache.get(itemsItem);
                if (cacheitems != null) {
                    itemsManagedCopy.add(cacheitems);
                } else {
                    itemsManagedCopy.add(com_refresh_pos_domain_inventory_LineItemRealmProxy.copyOrUpdate(realm, (com_refresh_pos_domain_inventory_LineItemRealmProxy.LineItemColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.LineItem.class), itemsItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.itemsColKey, itemsManagedCopy);
        } else {
            builder.addObjectList(columnInfo.itemsColKey, new RealmList<com.refresh.pos.domain.inventory.LineItem>());
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
        StringBuilder stringBuilder = new StringBuilder("Sale = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{startTime:");
        stringBuilder.append(realmGet$startTime() != null ? realmGet$startTime() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{endTime:");
        stringBuilder.append(realmGet$endTime() != null ? realmGet$endTime() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status() != null ? realmGet$status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{discount:");
        stringBuilder.append(realmGet$discount() != null ? realmGet$discount() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{total:");
        stringBuilder.append(realmGet$total() != null ? realmGet$total() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mobile:");
        stringBuilder.append(realmGet$mobile() != null ? realmGet$mobile() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{items:");
        stringBuilder.append("RealmList<LineItem>[").append(realmGet$items().size()).append("]");
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
        com_refresh_pos_domain_sale_SaleRealmProxy aSale = (com_refresh_pos_domain_sale_SaleRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aSale.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSale.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aSale.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
