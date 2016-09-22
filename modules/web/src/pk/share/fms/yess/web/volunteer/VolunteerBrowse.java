package pk.share.fms.yess.web.volunteer;

import pk.share.fms.yess.entity.Volunteer;
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

public class VolunteerBrowse extends AbstractLookup {

    @Inject
    private CollectionDatasource<Volunteer, UUID> volunteersDs;

    @Inject
    private Datasource<Volunteer> volunteerDs;

    @Inject
    private Table<Volunteer> volunteersTable;

    @Inject
    private BoxLayout lookupBox;

    @Inject
    private BoxLayout actionsPane;

    @Inject
    private FieldGroup fieldGroup;
    
    @Named("volunteersTable.remove")
    private RemoveAction volunteersTableRemove;
    
    @Inject
    private DataSupplier dataSupplier;

    private boolean creating;

    @Override
    public void init(Map<String, Object> params) {
        volunteersDs.addItemChangeListener(e -> {
            if (e.getItem() != null) {
                Volunteer reloadedItem = dataSupplier.reload(e.getDs().getItem(), volunteerDs.getView());
                volunteerDs.setItem(reloadedItem);
            }
        });
        
        volunteersTable.addAction(new CreateAction(volunteersTable) {
            @Override
            protected void internalOpenEditor(CollectionDatasource datasource, Entity newItem, Datasource parentDs, Map<String, Object> params) {
                volunteersTable.setSelected(Collections.emptyList());
                volunteerDs.setItem((Volunteer) newItem);
                enableEditControls(true);
            }
        });

        volunteersTable.addAction(new EditAction(volunteersTable) {
            @Override
            protected void internalOpenEditor(CollectionDatasource datasource, Entity existingItem, Datasource parentDs, Map<String, Object> params) {
                if (volunteersTable.getSelected().size() == 1) {
                    enableEditControls(false);
                }
            }
        });
        
        volunteersTableRemove.setAfterRemoveHandler(removedItems -> volunteerDs.setItem(null));
        
        disableEditControls();
    }

    public void save() {
        getDsContext().commit();

        Volunteer editedItem = volunteerDs.getItem();
        if (creating) {
            volunteersDs.includeItem(editedItem);
        } else {
            volunteersDs.updateItem(editedItem);
        }
        volunteersTable.setSelected(editedItem);

        disableEditControls();
    }

    public void cancel() {
        Volunteer selectedItem = volunteersDs.getItem();
        if (selectedItem != null) {
            Volunteer reloadedItem = dataSupplier.reload(selectedItem, volunteerDs.getView());
            volunteersDs.setItem(reloadedItem);
        } else {
            volunteerDs.setItem(null);
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
        volunteersTable.requestFocus();
    }

    private void initEditComponents(boolean enabled) {
        fieldGroup.setEditable(enabled);
        actionsPane.setVisible(enabled);
        lookupBox.setEnabled(!enabled);
    }
}