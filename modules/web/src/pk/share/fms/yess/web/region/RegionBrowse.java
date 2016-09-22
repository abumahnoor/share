package pk.share.fms.yess.web.region;

import pk.share.fms.yess.entity.Region;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;
import com.haulmont.cuba.gui.components.actions.RemoveAction;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class RegionBrowse extends AbstractLookup {

    @Inject
    private CollectionDatasource<Region, Integer> regionsDs;

    @Inject
    private Datasource<Region> regionDs;

    @Inject
    private Table<Region> regionsTable;

    @Inject
    private BoxLayout lookupBox;

    @Inject
    private BoxLayout actionsPane;

    @Inject
    private FieldGroup fieldGroup;
    
    @Named("regionsTable.remove")
    private RemoveAction regionsTableRemove;
    
    @Inject
    private DataSupplier dataSupplier;

    private boolean creating;

    @Override
    public void init(Map<String, Object> params) {
        regionsDs.addItemChangeListener(e -> {
            if (e.getItem() != null) {
                Region reloadedItem = dataSupplier.reload(e.getDs().getItem(), regionDs.getView());
                regionDs.setItem(reloadedItem);
            }
        });
        
        regionsTable.addAction(new CreateAction(regionsTable) {
            @Override
            protected void internalOpenEditor(CollectionDatasource datasource, Entity newItem, Datasource parentDs, Map<String, Object> params) {
                regionsTable.setSelected(Collections.emptyList());
                regionDs.setItem((Region) newItem);
                enableEditControls(true);
            }
        });

        regionsTable.addAction(new EditAction(regionsTable) {
            @Override
            protected void internalOpenEditor(CollectionDatasource datasource, Entity existingItem, Datasource parentDs, Map<String, Object> params) {
                if (regionsTable.getSelected().size() == 1) {
                    enableEditControls(false);
                }
            }
        });
        
        regionsTableRemove.setAfterRemoveHandler(removedItems -> regionDs.setItem(null));
        
        disableEditControls();
    }

    public void save() {
        getDsContext().commit();

        Region editedItem = regionDs.getItem();
        if (creating) {
            regionsDs.includeItem(editedItem);
        } else {
            regionsDs.updateItem(editedItem);
        }
        regionsTable.setSelected(editedItem);

        disableEditControls();
    }

    public void cancel() {
        Region selectedItem = regionsDs.getItem();
        if (selectedItem != null) {
            Region reloadedItem = dataSupplier.reload(selectedItem, regionDs.getView());
            regionsDs.setItem(reloadedItem);
        } else {
            regionDs.setItem(null);
        }

        disableEditControls();
    }

    private void enableEditControls(boolean creating) {
        this.creating = creating;
        initEditComponents(true);
        fieldGroup.requestFocus();
    }

    private void disableEditControls() {
        initEditComponents(false);
        regionsTable.requestFocus();
    }

    private void initEditComponents(boolean enabled) {
        fieldGroup.setEditable(enabled);
        actionsPane.setVisible(enabled);
        lookupBox.setEnabled(!enabled);
    }
}