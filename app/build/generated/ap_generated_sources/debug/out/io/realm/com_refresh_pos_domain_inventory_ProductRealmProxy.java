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
public class com_refresh_pos_domain_inventory_ProductRealmProxy extends com.refresh.pos.domain.inventory.Product
    implements RealmObjectProxy, com_refresh_pos_domain_inventory_ProductRealmProxyInterface {

    static final class ProductColumnInfo extends ColumnInfo {
        long idColKey;
        long nameColKey;
        long barcodeColKey;
        long unitPriceColKey;

        ProductColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Product");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.nameColKey = addColumnDetails("name", "name", objectSchemaInfo);
            this.barcodeColKey = addColumnDetails("barcode", "barcode", objectSchemaInfo);
            this.unitPriceColKey = addColumnDetails("unitPrice", "unitPrice", objectSchemaInfo);
        }

        ProductColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ProductColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ProductColumnInfo src = (ProductColumnInfo) rawSrc;
            final ProductColumnInfo dst = (ProductColumnInfo) rawDst;
            dst.idColKey = src.idColKey;
            dst.nameColKey = src.nameColKey;
            dst.barcodeColKey = src.barcodeColKey;
            dst.unitPriceColKey = src.unitPriceColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ProductColumnInfo columnInfo;
    private ProxyState<com.refresh.pos.domain.inventory.Product> proxyState;

    com_refresh_pos_domain_inventory_ProductRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ProductColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.refresh.pos.domain.inventory.Product>(this);
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
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameColKey);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$barcode() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.barcodeColKey);
    }

    @Override
    public void realmSet$barcode(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.barcodeColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.barcodeColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.barcodeColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.barcodeColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$unitPrice() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.unitPriceColKey);
    }

    @Override
    public void realmSet$unitPrice(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.unitPriceColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.unitPriceColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Product", false, 4, 0);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "barcode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "unitPrice", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ProductColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ProductColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Product";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Product";
    }

    @SuppressWarnings("cast")
    public static com.refresh.pos.domain.inventory.Product createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.refresh.pos.domain.inventory.Product obj = null;
        if (update) {
            Table table = realm.getTable(com.refresh.pos.domain.inventory.Product.class);
            ProductColumnInfo columnInfo = (ProductColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.Product.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = Table.NO_MATCH;
            if (!json.isNull("id")) {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("id"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.Product.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy) realm.createObjectInternal(com.refresh.pos.domain.inventory.Product.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy) realm.createObjectInternal(com.refresh.pos.domain.inventory.Product.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_refresh_pos_domain_inventory_ProductRealmProxyInterface objProxy = (com_refresh_pos_domain_inventory_ProductRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("barcode")) {
            if (json.isNull("barcode")) {
                objProxy.realmSet$barcode(null);
            } else {
                objProxy.realmSet$barcode((String) json.getString("barcode"));
            }
        }
        if (json.has("unitPrice")) {
            if (json.isNull("unitPrice")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'unitPrice' to null.");
            } else {
                objProxy.realmSet$unitPrice((double) json.getDouble("unitPrice"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.refresh.pos.domain.inventory.Product createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.refresh.pos.domain.inventory.Product obj = new com.refresh.pos.domain.inventory.Product();
        final com_refresh_pos_domain_inventory_ProductRealmProxyInterface objProxy = (com_refresh_pos_domain_inventory_ProductRealmProxyInterface) obj;
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
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("barcode")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$barcode((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$barcode(null);
                }
            } else if (name.equals("unitPrice")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$unitPrice((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'unitPrice' to null.");
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

    static com_refresh_pos_domain_inventory_ProductRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.Product.class), false, Collections.<String>emptyList());
        io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy obj = new io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.refresh.pos.domain.inventory.Product copyOrUpdate(Realm realm, ProductColumnInfo columnInfo, com.refresh.pos.domain.inventory.Product object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.refresh.pos.domain.inventory.Product) cachedRealmObject;
        }

        com.refresh.pos.domain.inventory.Product realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.refresh.pos.domain.inventory.Product.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = table.findFirstLong(pkColumnKey, ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$id());
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.refresh.pos.domain.inventory.Product copy(Realm realm, ProductColumnInfo columnInfo, com.refresh.pos.domain.inventory.Product newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.refresh.pos.domain.inventory.Product) cachedRealmObject;
        }

        com_refresh_pos_domain_inventory_ProductRealmProxyInterface unmanagedSource = (com_refresh_pos_domain_inventory_ProductRealmProxyInterface) newObject;

        Table table = realm.getTable(com.refresh.pos.domain.inventory.Product.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addString(columnInfo.nameColKey, unmanagedSource.realmGet$name());
        builder.addString(columnInfo.barcodeColKey, unmanagedSource.realmGet$barcode());
        builder.addDouble(columnInfo.unitPriceColKey, unmanagedSource.realmGet$unitPrice());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.refresh.pos.domain.inventory.Product object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.refresh.pos.domain.inventory.Product.class);
        long tableNativePtr = table.getNativePtr();
        ProductColumnInfo columnInfo = (ProductColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.Product.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$name = ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
        }
        String realmGet$barcode = ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$barcode();
        if (realmGet$barcode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.barcodeColKey, objKey, realmGet$barcode, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.unitPriceColKey, objKey, ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$unitPrice(), false);
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.refresh.pos.domain.inventory.Product.class);
        long tableNativePtr = table.getNativePtr();
        ProductColumnInfo columnInfo = (ProductColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.Product.class);
        long pkColumnKey = columnInfo.idColKey;
        com.refresh.pos.domain.inventory.Product object = null;
        while (objects.hasNext()) {
            object = (com.refresh.pos.domain.inventory.Product) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$name = ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
            }
            String realmGet$barcode = ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$barcode();
            if (realmGet$barcode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.barcodeColKey, objKey, realmGet$barcode, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.unitPriceColKey, objKey, ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$unitPrice(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.refresh.pos.domain.inventory.Product object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.refresh.pos.domain.inventory.Product.class);
        long tableNativePtr = table.getNativePtr();
        ProductColumnInfo columnInfo = (ProductColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.Product.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, objKey);
        String realmGet$name = ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, objKey, false);
        }
        String realmGet$barcode = ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$barcode();
        if (realmGet$barcode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.barcodeColKey, objKey, realmGet$barcode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.barcodeColKey, objKey, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.unitPriceColKey, objKey, ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$unitPrice(), false);
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.refresh.pos.domain.inventory.Product.class);
        long tableNativePtr = table.getNativePtr();
        ProductColumnInfo columnInfo = (ProductColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.Product.class);
        long pkColumnKey = columnInfo.idColKey;
        com.refresh.pos.domain.inventory.Product object = null;
        while (objects.hasNext()) {
            object = (com.refresh.pos.domain.inventory.Product) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, objKey);
            String realmGet$name = ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, objKey, false);
            }
            String realmGet$barcode = ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$barcode();
            if (realmGet$barcode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.barcodeColKey, objKey, realmGet$barcode, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.barcodeColKey, objKey, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.unitPriceColKey, objKey, ((com_refresh_pos_domain_inventory_ProductRealmProxyInterface) object).realmGet$unitPrice(), false);
        }
    }

    public static com.refresh.pos.domain.inventory.Product createDetachedCopy(com.refresh.pos.domain.inventory.Product realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.refresh.pos.domain.inventory.Product unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.refresh.pos.domain.inventory.Product();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.refresh.pos.domain.inventory.Product) cachedObject.object;
            }
            unmanagedObject = (com.refresh.pos.domain.inventory.Product) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_refresh_pos_domain_inventory_ProductRealmProxyInterface unmanagedCopy = (com_refresh_pos_domain_inventory_ProductRealmProxyInterface) unmanagedObject;
        com_refresh_pos_domain_inventory_ProductRealmProxyInterface realmSource = (com_refresh_pos_domain_inventory_ProductRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$barcode(realmSource.realmGet$barcode());
        unmanagedCopy.realmSet$unitPrice(realmSource.realmGet$unitPrice());

        return unmanagedObject;
    }

    static com.refresh.pos.domain.inventory.Product update(Realm realm, ProductColumnInfo columnInfo, com.refresh.pos.domain.inventory.Product realmObject, com.refresh.pos.domain.inventory.Product newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_refresh_pos_domain_inventory_ProductRealmProxyInterface realmObjectTarget = (com_refresh_pos_domain_inventory_ProductRealmProxyInterface) realmObject;
        com_refresh_pos_domain_inventory_ProductRealmProxyInterface realmObjectSource = (com_refresh_pos_domain_inventory_ProductRealmProxyInterface) newObject;
        Table table = realm.getTable(com.refresh.pos.domain.inventory.Product.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nameColKey, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.barcodeColKey, realmObjectSource.realmGet$barcode());
        builder.addDouble(columnInfo.unitPriceColKey, realmObjectSource.realmGet$unitPrice());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Product = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{barcode:");
        stringBuilder.append(realmGet$barcode() != null ? realmGet$barcode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{unitPrice:");
        stringBuilder.append(realmGet$unitPrice());
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
        com_refresh_pos_domain_inventory_ProductRealmProxy aProduct = (com_refresh_pos_domain_inventory_ProductRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aProduct.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aProduct.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aProduct.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
