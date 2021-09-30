package io.realm;


import android.util.JsonReader;
import io.realm.ImportFlag;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(4);
        modelClasses.add(com.refresh.pos.domain.inventory.Product.class);
        modelClasses.add(com.refresh.pos.domain.inventory.LineItem.class);
        modelClasses.add(com.refresh.pos.domain.sale.QuickLoadSale.class);
        modelClasses.add(com.refresh.pos.domain.sale.Sale.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(4);
        infoMap.put(com.refresh.pos.domain.inventory.Product.class, io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.refresh.pos.domain.inventory.LineItem.class, io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.refresh.pos.domain.sale.QuickLoadSale.class, io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.refresh.pos.domain.sale.Sale.class, io.realm.com_refresh_pos_domain_sale_SaleRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.refresh.pos.domain.inventory.Product.class)) {
            return io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.refresh.pos.domain.inventory.LineItem.class)) {
            return io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.refresh.pos.domain.sale.QuickLoadSale.class)) {
            return io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.refresh.pos.domain.sale.Sale.class)) {
            return io.realm.com_refresh_pos_domain_sale_SaleRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.refresh.pos.domain.inventory.Product.class)) {
            return "Product";
        }
        if (clazz.equals(com.refresh.pos.domain.inventory.LineItem.class)) {
            return "LineItem";
        }
        if (clazz.equals(com.refresh.pos.domain.sale.QuickLoadSale.class)) {
            return "QuickLoadSale";
        }
        if (clazz.equals(com.refresh.pos.domain.sale.Sale.class)) {
            return "Sale";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public Class<? extends RealmModel> getClazzImpl(String className) {
        checkClassName(className);

        if (className.equals("Product")) {
            return com.refresh.pos.domain.inventory.Product.class;
        }
        if (className.equals("LineItem")) {
            return com.refresh.pos.domain.inventory.LineItem.class;
        }
        if (className.equals("QuickLoadSale")) {
            return com.refresh.pos.domain.sale.QuickLoadSale.class;
        }
        if (className.equals("Sale")) {
            return com.refresh.pos.domain.sale.Sale.class;
        }
        throw getMissingProxyClassException(className);
    }

    @Override
    public boolean hasPrimaryKeyImpl(Class<? extends RealmModel> clazz) {
        return com.refresh.pos.domain.inventory.Product.class.isAssignableFrom(clazz)
                || com.refresh.pos.domain.inventory.LineItem.class.isAssignableFrom(clazz)
                || com.refresh.pos.domain.sale.QuickLoadSale.class.isAssignableFrom(clazz)
                || com.refresh.pos.domain.sale.Sale.class.isAssignableFrom(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.refresh.pos.domain.inventory.Product.class)) {
                return clazz.cast(new io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy());
            }
            if (clazz.equals(com.refresh.pos.domain.inventory.LineItem.class)) {
                return clazz.cast(new io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy());
            }
            if (clazz.equals(com.refresh.pos.domain.sale.QuickLoadSale.class)) {
                return clazz.cast(new io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy());
            }
            if (clazz.equals(com.refresh.pos.domain.sale.Sale.class)) {
                return clazz.cast(new io.realm.com_refresh_pos_domain_sale_SaleRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.refresh.pos.domain.inventory.Product.class)) {
            com_refresh_pos_domain_inventory_ProductRealmProxy.ProductColumnInfo columnInfo = (com_refresh_pos_domain_inventory_ProductRealmProxy.ProductColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.Product.class);
            return clazz.cast(io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy.copyOrUpdate(realm, columnInfo, (com.refresh.pos.domain.inventory.Product) obj, update, cache, flags));
        }
        if (clazz.equals(com.refresh.pos.domain.inventory.LineItem.class)) {
            com_refresh_pos_domain_inventory_LineItemRealmProxy.LineItemColumnInfo columnInfo = (com_refresh_pos_domain_inventory_LineItemRealmProxy.LineItemColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.inventory.LineItem.class);
            return clazz.cast(io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy.copyOrUpdate(realm, columnInfo, (com.refresh.pos.domain.inventory.LineItem) obj, update, cache, flags));
        }
        if (clazz.equals(com.refresh.pos.domain.sale.QuickLoadSale.class)) {
            com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy.QuickLoadSaleColumnInfo columnInfo = (com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy.QuickLoadSaleColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.QuickLoadSale.class);
            return clazz.cast(io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy.copyOrUpdate(realm, columnInfo, (com.refresh.pos.domain.sale.QuickLoadSale) obj, update, cache, flags));
        }
        if (clazz.equals(com.refresh.pos.domain.sale.Sale.class)) {
            com_refresh_pos_domain_sale_SaleRealmProxy.SaleColumnInfo columnInfo = (com_refresh_pos_domain_sale_SaleRealmProxy.SaleColumnInfo) realm.getSchema().getColumnInfo(com.refresh.pos.domain.sale.Sale.class);
            return clazz.cast(io.realm.com_refresh_pos_domain_sale_SaleRealmProxy.copyOrUpdate(realm, columnInfo, (com.refresh.pos.domain.sale.Sale) obj, update, cache, flags));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public long insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.refresh.pos.domain.inventory.Product.class)) {
            return io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy.insert(realm, (com.refresh.pos.domain.inventory.Product) object, cache);
        } else if (clazz.equals(com.refresh.pos.domain.inventory.LineItem.class)) {
            return io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy.insert(realm, (com.refresh.pos.domain.inventory.LineItem) object, cache);
        } else if (clazz.equals(com.refresh.pos.domain.sale.QuickLoadSale.class)) {
            return io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy.insert(realm, (com.refresh.pos.domain.sale.QuickLoadSale) object, cache);
        } else if (clazz.equals(com.refresh.pos.domain.sale.Sale.class)) {
            return io.realm.com_refresh_pos_domain_sale_SaleRealmProxy.insert(realm, (com.refresh.pos.domain.sale.Sale) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.refresh.pos.domain.inventory.Product.class)) {
                io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy.insert(realm, (com.refresh.pos.domain.inventory.Product) object, cache);
            } else if (clazz.equals(com.refresh.pos.domain.inventory.LineItem.class)) {
                io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy.insert(realm, (com.refresh.pos.domain.inventory.LineItem) object, cache);
            } else if (clazz.equals(com.refresh.pos.domain.sale.QuickLoadSale.class)) {
                io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy.insert(realm, (com.refresh.pos.domain.sale.QuickLoadSale) object, cache);
            } else if (clazz.equals(com.refresh.pos.domain.sale.Sale.class)) {
                io.realm.com_refresh_pos_domain_sale_SaleRealmProxy.insert(realm, (com.refresh.pos.domain.sale.Sale) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.refresh.pos.domain.inventory.Product.class)) {
                    io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.refresh.pos.domain.inventory.LineItem.class)) {
                    io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.refresh.pos.domain.sale.QuickLoadSale.class)) {
                    io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.refresh.pos.domain.sale.Sale.class)) {
                    io.realm.com_refresh_pos_domain_sale_SaleRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public long insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.refresh.pos.domain.inventory.Product.class)) {
            return io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy.insertOrUpdate(realm, (com.refresh.pos.domain.inventory.Product) obj, cache);
        } else if (clazz.equals(com.refresh.pos.domain.inventory.LineItem.class)) {
            return io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy.insertOrUpdate(realm, (com.refresh.pos.domain.inventory.LineItem) obj, cache);
        } else if (clazz.equals(com.refresh.pos.domain.sale.QuickLoadSale.class)) {
            return io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy.insertOrUpdate(realm, (com.refresh.pos.domain.sale.QuickLoadSale) obj, cache);
        } else if (clazz.equals(com.refresh.pos.domain.sale.Sale.class)) {
            return io.realm.com_refresh_pos_domain_sale_SaleRealmProxy.insertOrUpdate(realm, (com.refresh.pos.domain.sale.Sale) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.refresh.pos.domain.inventory.Product.class)) {
                io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy.insertOrUpdate(realm, (com.refresh.pos.domain.inventory.Product) object, cache);
            } else if (clazz.equals(com.refresh.pos.domain.inventory.LineItem.class)) {
                io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy.insertOrUpdate(realm, (com.refresh.pos.domain.inventory.LineItem) object, cache);
            } else if (clazz.equals(com.refresh.pos.domain.sale.QuickLoadSale.class)) {
                io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy.insertOrUpdate(realm, (com.refresh.pos.domain.sale.QuickLoadSale) object, cache);
            } else if (clazz.equals(com.refresh.pos.domain.sale.Sale.class)) {
                io.realm.com_refresh_pos_domain_sale_SaleRealmProxy.insertOrUpdate(realm, (com.refresh.pos.domain.sale.Sale) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.refresh.pos.domain.inventory.Product.class)) {
                    io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.refresh.pos.domain.inventory.LineItem.class)) {
                    io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.refresh.pos.domain.sale.QuickLoadSale.class)) {
                    io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.refresh.pos.domain.sale.Sale.class)) {
                    io.realm.com_refresh_pos_domain_sale_SaleRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.refresh.pos.domain.inventory.Product.class)) {
            return clazz.cast(io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.refresh.pos.domain.inventory.LineItem.class)) {
            return clazz.cast(io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.refresh.pos.domain.sale.QuickLoadSale.class)) {
            return clazz.cast(io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.refresh.pos.domain.sale.Sale.class)) {
            return clazz.cast(io.realm.com_refresh_pos_domain_sale_SaleRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.refresh.pos.domain.inventory.Product.class)) {
            return clazz.cast(io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.refresh.pos.domain.inventory.LineItem.class)) {
            return clazz.cast(io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.refresh.pos.domain.sale.QuickLoadSale.class)) {
            return clazz.cast(io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.refresh.pos.domain.sale.Sale.class)) {
            return clazz.cast(io.realm.com_refresh_pos_domain_sale_SaleRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.refresh.pos.domain.inventory.Product.class)) {
            return clazz.cast(io.realm.com_refresh_pos_domain_inventory_ProductRealmProxy.createDetachedCopy((com.refresh.pos.domain.inventory.Product) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.refresh.pos.domain.inventory.LineItem.class)) {
            return clazz.cast(io.realm.com_refresh_pos_domain_inventory_LineItemRealmProxy.createDetachedCopy((com.refresh.pos.domain.inventory.LineItem) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.refresh.pos.domain.sale.QuickLoadSale.class)) {
            return clazz.cast(io.realm.com_refresh_pos_domain_sale_QuickLoadSaleRealmProxy.createDetachedCopy((com.refresh.pos.domain.sale.QuickLoadSale) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.refresh.pos.domain.sale.Sale.class)) {
            return clazz.cast(io.realm.com_refresh_pos_domain_sale_SaleRealmProxy.createDetachedCopy((com.refresh.pos.domain.sale.Sale) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> boolean isEmbedded(Class<E> clazz) {
        if (clazz.equals(com.refresh.pos.domain.inventory.Product.class)) {
            return false;
        }
        if (clazz.equals(com.refresh.pos.domain.inventory.LineItem.class)) {
            return false;
        }
        if (clazz.equals(com.refresh.pos.domain.sale.QuickLoadSale.class)) {
            return false;
        }
        if (clazz.equals(com.refresh.pos.domain.sale.Sale.class)) {
            return false;
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> void updateEmbeddedObject(Realm realm, E unmanagedObject, E managedObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) managedObject.getClass().getSuperclass();

        if (clazz.equals(com.refresh.pos.domain.inventory.Product.class)) {
            throw getNotEmbeddedClassException("com.refresh.pos.domain.inventory.Product");
        } else if (clazz.equals(com.refresh.pos.domain.inventory.LineItem.class)) {
            throw getNotEmbeddedClassException("com.refresh.pos.domain.inventory.LineItem");
        } else if (clazz.equals(com.refresh.pos.domain.sale.QuickLoadSale.class)) {
            throw getNotEmbeddedClassException("com.refresh.pos.domain.sale.QuickLoadSale");
        } else if (clazz.equals(com.refresh.pos.domain.sale.Sale.class)) {
            throw getNotEmbeddedClassException("com.refresh.pos.domain.sale.Sale");
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}
