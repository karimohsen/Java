/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlapplab2;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 *
 * @author Karim
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TreeView<File> tree;

    @FXML
    private ListView<String> list;

    ObservableList<String> names = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tree.setRoot(createNode(new File("C:/")));
        tree.setCellFactory(new Callback<TreeView<File>, TreeCell<File>>() {

            @Override
            public TreeCell<File> call(TreeView<File> p) {
          return new TreeCellFactory();
            }
        });
        list.setItems(names);
    }

    private TreeItem<File> createNode(final File file) {
        return new TreeItem<File>(file) {
            private boolean isLeaf;
            private boolean isFirstTimeChild = true;
            private boolean isFirstTimeLeaf = true;

            @Override
            public ObservableList<TreeItem<File>> getChildren() {
                if (isFirstTimeChild) {
                    isFirstTimeChild = false;
                    super.getChildren().setAll(buildChildren(this));
                }
                return super.getChildren();
            }

            private ObservableList<TreeItem<File>> buildChildren(TreeItem<File> tree) {
                File f = tree.getValue();
                if (f != null && f.isDirectory()) {
                    File[] files = f.listFiles();
                    if (files != null) {
                        ObservableList<TreeItem<File>> children = FXCollections.observableArrayList();
                        for (File childFile : files) {
                            children.add(createNode(childFile));
                        }
                        return children;
                    }
                }
                return FXCollections.emptyObservableList();
            }

            @Override
            public boolean isLeaf() {
                if (isFirstTimeLeaf) {
                    isFirstTimeLeaf = false;
                    File f = (File) getValue();
                    isLeaf = f.isFile();
                }
                return isLeaf;
            }
        };
    }

    public class TreeCellFactory extends TreeCell<File> {

        @Override
        protected void updateItem(final File item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null && !empty) {
                Text text = new Text(item.getName());
                
                text.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {
                        File f = item;
                        names.clear();
                        if (f != null && f.isDirectory()) {
                            File[] files = f.listFiles();
                            if (files != null) {

                                for (File childFile : files) {
                                    names.add(childFile.getName());
                                }
                            }
                        }
                    }
                });
                setGraphic(text);
            }
        }
    }
}
