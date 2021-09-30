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
public class com_refresh_pos_domain_inventory_LineItemRealmProxy extends com.refresh.pos.domain.inventory.LineItem
    implements RealmObjectProxy, com_refresh_pos_domain_inventory_LineItemRealmProxyInterface {

    static final class LineItemColumnInfo extends ColumnInfo {
        long productColKey;
        long quantityColKey;
        long idColKey;
        long unitPriceAtSaleColKey;

        LineItemColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("LineItem");
            this.productColKey = addColumnDetails("product", "product", objectSchemaInfo);
            this.quantityColKey = addColumnDetails("quantity", "quantity", objectSchemaInfo);
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.unitPriceAtSaleColKey = addColumnDetails("unitPriceAtSale", "unitPriceAtSale", objectSchemaInfo);
        }

        LineItemColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new LineItemColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final LineItemColumnInfo src = (LineItemColumnInfo) rawSrc;
            final LineItemColumnInfo dst = (LineItemColumnInfo) rawDst;
            dst.productColKey = src.productColKey;
            dst.quantityColKey = src.quantityColKey;
            dst.idColKey = src.idColKey;
            dst.unitPriceAtSaleColKey = src.unitPriceAtSaleColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private LineItemColumnInfo columnInfo;
    private ProxyState<com.refresh.pos.domain.inventory.LineItem> proxyState;

    com_refresh_pos_domain_inventory_LineItemRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (LineItemColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.refresh.pos.domain.inventory.LineItem>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    public com.refresh.pos.domain.inventory.Product realmGet$product() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.productColKey)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.refresh.pos.domain.inventory.Product.class, proxyState.getRow$realm().getLink(columnInfo.productColKey), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$product(com.refresh.pos.domain.inventory.Product value) {
        Realm realm = (Realm) proxyState.getRealm$realm();
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("product")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = realm.copyToRealmOrUpdate(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.productColKey);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.productColKey, row.getObjectKey(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.productColKey);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.productColKey, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$quantity() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.quantityColKey);
    }

    @Override
    public void realmSet$quantity(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.quantityColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.quantityColKey, value);
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
    public double realmGet$unitPriceAtSale() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.unitPriceAtSaleColKey);
    }

    @Override
    public void realmSet$unitPriceAtSale(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.unitPriceAtSaleColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.unitPriceAtSaleColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "LineItem", false, 4, 0);
        builder.addPersistedLinkProperty(NO_ALIAS, "product", RealmFieldType.OBJECT, "Product");
        builder.addPersistedProperty(NO_ALIAS, "quantity", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "unitPriceAtSale", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static LineItemColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new LineItemColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "LineItem";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "LineItem";
    }

    @SuppressWarnings("cast")
    public static com.refresh.pos.domain.inventory.LineItem createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.refresh.pos.domain.inventory.LineItem obj = null;
        if (update) {
            Table table = realm.getTable(com.refresh.pos.domain.inventory.LineItem.class);
            LineItemColumnInfo columnInfo = (LineItemColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.LineItem.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = Table.NO_MATCH;
            if (!json.isNull("id")) {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("id"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.LineItem.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("product")) {
                excludeFields.add("product");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy) realm.createObjectInternal(com.refresh.pos.domain.inventory.LineItem.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy) realm.createObjectInternal(com.refresh.pos.domain.inventory.LineItem.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_refresh_pos_domain_inventory_LineItemRealmProxyInterface objProxy = (com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) obj;
        if (json.has("product")) {
            if (json.isNull("product")) {
                objProxy.realmSet$product(null);
            } else {
                com.refresh.pos.domain.inventory.Product productObj = com_refresh_pos_domain_inventory_ProductRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("product"), update);
                objProxy.realmSet$product(productObj);
            }
        }
        if (json.has("quantity")) {
            if (json.isNull("quantity")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'quantity' to null.");
            } else {
                objProxy.realmSet$quantity((int) json.getInt("quantity"));
            }
        }
        if (json.has("unitPriceAtSale")) {
            if (json.isNull("unitPriceAtSale")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'unitPriceAtSale' to null.");
            } else {
                objProxy.realmSet$unitPriceAtSale((double) json.getDouble("unitPriceAtSale"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.refresh.pos.domain.inventory.LineItem createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.refresh.pos.domain.inventory.LineItem obj = new com.refresh.pos.domain.inventory.LineItem();
        final com_refresh_pos_domain_inventory_LineItemRealmProxyInterface objProxy = (com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("product")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$product(null);
                } else {
                    com.refresh.pos.domain.inventory.Product productObj = com_refresh_pos_domain_inventory_ProductRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$product(productObj);
                }
            } else if (name.equals("quantity")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$quantity((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'quantity' to null.");
                }
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("unitPriceAtSale")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$unitPriceAtSale((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'unitPriceAtSale' to null.");
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

    static com_refresh_pos_domain_inventory_LineItemRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.LineItem.class), false, Collections.<String>emptyList());
        io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy obj = new io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.refresh.pos.domain.inventory.LineItem copyOrUpdate(Realm realm, LineItemColumnInfo columnInfo, com.refresh.pos.domain.inventory.LineItem object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.refresh.pos.domain.inventory.LineItem) cachedRealmObject;
        }

        com.refresh.pos.domain.inventory.LineItem realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.refresh.pos.domain.inventory.LineItem.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = table.findFirstLong(pkColumnKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$id());
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.refresh.pos.domain.inventory.LineItem copy(Realm realm, LineItemColumnInfo columnInfo, com.refresh.pos.domain.inventory.LineItem newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.refresh.pos.domain.inventory.LineItem) cachedRealmObject;
        }

        com_refresh_pos_domain_inventory_LineItemRealmProxyInterface unmanagedSource = (com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) newObject;

        Table table = realm.getTable(com.refresh.pos.domain.inventory.LineItem.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.quantityColKey, unmanagedSource.realmGet$quantity());
        builder.addInteger(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addDouble(columnInfo.unitPriceAtSaleColKey, unmanagedSource.realmGet$unitPriceAtSale());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        com.refresh.pos.domain.inventory.Product productObj = unmanagedSource.realmGet$product();
        if (productObj == null) {
            managedCopy.realmSet$product(null);
        } else {
            com.refresh.pos.domain.inventory.Product cacheproduct = (com.refresh.pos.domain.inventory.Product) cache.get(productObj);
            if (cacheproduct != null) {
                managedCopy.realmSet$product(cacheproduct);
            } else {
                managedCopy.realmSet$product(com_refresh_pos_domain_inventory_ProductRealmProxy.copyOrUpdate(realm, (com_refresh_pos_domain_inventory_ProductRealmProxy.ProductColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.Product.class), productObj, update, cache, flags));
            }
        }

        return managedCopy;
    }

    public static long insert(Realm realm, com.refresh.pos.domain.inventory.LineItem object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.refresh.pos.domain.inventory.LineItem.class);
        long tableNativePtr = table.getNativePtr();
        LineItemColumnInfo columnInfo = (LineItemColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.LineItem.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);

        com.refresh.pos.domain.inventory.Product productObj = ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$product();
        if (productObj != null) {
            Long cacheproduct = cache.get(productObj);
            if (cacheproduct == null) {
                cacheproduct = com_refresh_pos_domain_inventory_ProductRealmProxy.insert(realm, productObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.productColKey, objKey, cacheproduct, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.quantityColKey, objKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$quantity(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.unitPriceAtSaleColKey, objKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$unitPriceAtSale(), false);
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.refresh.pos.domain.inventory.LineItem.class);
        long tableNativePtr = table.getNativePtr();
        LineItemColumnInfo columnInfo = (LineItemColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.LineItem.class);
        long pkColumnKey = columnInfo.idColKey;
        com.refresh.pos.domain.inventory.LineItem object = null;
        while (objects.hasNext()) {
            object = (com.refresh.pos.domain.inventory.LineItem) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);

            com.refresh.pos.domain.inventory.Product productObj = ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$product();
            if (productObj != null) {
                Long cacheproduct = cache.get(productObj);
                if (cacheproduct == null) {
                    cacheproduct = com_refresh_pos_domain_inventory_ProductRealmProxy.insert(realm, productObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.productColKey, objKey, cacheproduct, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.quantityColKey, objKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$quantity(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.unitPriceAtSaleColKey, objKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$unitPriceAtSale(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.refresh.pos.domain.inventory.LineItem object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.refresh.pos.domain.inventory.LineItem.class);
        long tableNativePtr = table.getNativePtr();
        LineItemColumnInfo columnInfo = (LineItemColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.LineItem.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, objKey);

        com.refresh.pos.domain.inventory.Product productObj = ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$product();
        if (productObj != null) {
            Long cacheproduct = cache.get(productObj);
            if (cacheproduct == null) {
                cacheproduct = com_refresh_pos_domain_inventory_ProductRealmProxy.insertOrUpdate(realm, productObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.productColKey, objKey, cacheproduct, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.productColKey, objKey);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.quantityColKey, objKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$quantity(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.unitPriceAtSaleColKey, objKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$unitPriceAtSale(), false);
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.refresh.pos.domain.inventory.LineItem.class);
        long tableNativePtr = table.getNativePtr();
        LineItemColumnInfo columnInfo = (LineItemColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.LineItem.class);
        long pkColumnKey = columnInfo.idColKey;
        com.refresh.pos.domain.inventory.LineItem object = null;
        while (objects.hasNext()) {
            object = (com.refresh.pos.domain.inventory.LineItem) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, objKey);

            com.refresh.pos.domain.inventory.Product productObj = ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$product();
            if (productObj != null) {
                Long cacheproduct = cache.get(productObj);
                if (cacheproduct == null) {
                    cacheproduct = com_refresh_pos_domain_inventory_ProductRealmProxy.insertOrUpdate(realm, productObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.productColKey, objKey, cacheproduct, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.productColKey, objKey);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.quantityColKey, objKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$quantity(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.unitPriceAtSaleColKey, objKey, ((com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) object).realmGet$unitPriceAtSale(), false);
        }
    }

    public static com.refresh.pos.domain.inventory.LineItem createDetachedCopy(com.refresh.pos.domain.inventory.LineItem realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.refresh.pos.domain.inventory.LineItem unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.refresh.pos.domain.inventory.LineItem();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.refresh.pos.domain.inventory.LineItem) cachedObject.object;
            }
            unmanagedObject = (com.refresh.pos.domain.inventory.LineItem) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_refresh_pos_domain_inventory_LineItemRealmProxyInterface unmanagedCopy = (com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) unmanagedObject;
        com_refresh_pos_domain_inventory_LineItemRealmProxyInterface realmSource = (com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();

        // Deep copy of product
        unmanagedCopy.realmSet$product(com_refresh_pos_domain_inventory_ProductRealmProxy.createDetachedCopy(realmSource.realmGet$product(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$quantity(realmSource.realmGet$quantity());
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$unitPriceAtSale(realmSource.realmGet$unitPriceAtSale());

        return unmanagedObject;
    }

    static com.refresh.pos.domain.inventory.LineItem update(Realm realm, LineItemColumnInfo columnInfo, com.refresh.pos.domain.inventory.LineItem realmObject, com.refresh.pos.domain.inventory.LineItem newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_refresh_pos_domain_inventory_LineItemRealmProxyInterface realmObjectTarget = (com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) realmObject;
        com_refresh_pos_domain_inventory_LineItemRealmProxyInterface realmObjectSource = (com_refresh_pos_domain_inventory_LineItemRealmProxyInterface) newObject;
        Table table = realm.getTable(com.refresh.pos.domain.inventory.LineItem.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        com.refresh.pos.domain.inventory.Product productObj = realmObjectSource.realmGet$product();
        if (productObj == null) {
            builder.addNull(columnInfo.productColKey);
        } else {
            com.refresh.pos.domain.inventory.Product cacheproduct = (com.refresh.pos.domain.inventory.Product) cache.get(productObj);
            if (cacheproduct != null) {
                builder.addObject(columnInfo.productColKey, cacheproduct);
            } else {
                builder.addObject(columnInfo.productColKey, com_refresh_pos_domain_inventory_ProductRealmProxy.copyOrUpdate(realm, (com_refresh_pos_domain_inventory_ProductRealmProxy.ProductColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.Product.class), productObj, true, cache, flags));
            }
        }
        builder.addInteger(columnInfo.quantityColKey, realmObjectSource.realmGet$quantity());
        builder.addInteger(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addDouble(columnInfo.unitPriceAtSaleColKey, realmObjectSource.realmGet$unitPriceAtSale());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("LineItem = proxy[");
        stringBuilder.append("{product:");
        stringBuilder.append(realmGet$product() != null ? "Product" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{quantity:");
        stringBuilder.append(realmGet$quantity());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{unitPriceAtSale:");
        stringBuilder.append(realmGet$unitPriceAtSale());
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

}
