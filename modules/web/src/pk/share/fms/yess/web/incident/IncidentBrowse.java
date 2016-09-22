package pk.share.fms.yess.web.incident;

import pk.share.fms.yess.entity.Incident;
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

public class IncidentBrowse extends AbstractLookup {

    @Inject
    private CollectionDatasource<Incident, UUID> incidentsDs;

    @Inject
    private Datasource<Incident> incidentDs;

    @Inject
    private Table<Incident> incidentsTable;

    @Inject
    private BoxLayout lookupBox;

    @Inject
    private BoxLayout actionsPane;

    @Named("incidentsTable.remove")
    private RemoveAction incidentsTableRemove;
    
    @Inject
    private DataSupplier dataSupplier;

    private boolean creating;

    @Override
    public void init(Map<String, Object> params) {
        incidentsDs.addItemChangeListener(e -> {
            if (e.getItem() != null) {
                Incident reloadedItem = dataSupplier.reload(e.getDs().getItem(), incidentDs.getView());
                incidentDs.setItem(reloadedItem);
            }
        });
        
        incidentsTable.addAction(new CreateAction(incidentsTable) {
            @Override
            protected void internalOpenEditor(CollectionDatasource datasource, Entity newItem, Datasource parentDs, Map<String, Object> params) {
                incidentsTable.setSelected(Collections.emptyList());
                incidentDs.setItem((Incident) newItem);
                enableEditControls(true);
            }
        });

        incidentsTable.addAction(new EditAction(incidentsTable) {
            @Override
            protected void internalOpenEditor(CollectionDatasource datasource, Entity existingItem, Datasource parentDs, Map<String, Object> params) {
                if (incidentsTable.getSelected().size() == 1) {
                    enableEditControls(false);
                }
            }
        });
        
        incidentsTableRemove.setAfterRemoveHandler(removedItems -> incidentDs.setItem(null));
        
        disableEditControls();
    }

    public void save() {
        getDsContext().commit();

        Incident editedItem = incidentDs.getItem();
        if (creating) {
            incidentsDs.includeItem(editedItem);
        } else {
            incidentsDs.updateItem(editedItem);
        }
        incidentsTable.setSelected(editedItem);

        disableEditControls();
    }

    public void cancel() {
        Incident selectedItem = incidentsDs.getItem();
        if (selectedItem != null) {
            Incident reloadedItem = dataSupplier.reload(selectedItem, incidentDs.getView());
            incidentsDs.setItem(reloadedItem);
        } else {
            incidentDs.setItem(null);
        }

        disableEditControls();
    }

    private void enableEditControls(boolean creating) {
        this.creating = creating;
        initEditComponents(true);
        //incidentEdit.requestFocus();
    }

    private void disableEditControls() {
        initEditComponents(false);
        incidentsTable.requestFocus();
    }

    private void initEditComponents(boolean enabled) {
        //fieldGroup.setEditable(enabled);
        actionsPane.setVisible(enabled);
        lookupBox.setEnabled(!enabled);
    }
}