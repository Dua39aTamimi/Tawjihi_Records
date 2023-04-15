package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {

	static double mean;
	static double mode;
	static double standardDeviation;
	static double median;
	Scene branch;
	Scene Home;
	static List wblist = new List();// for West Bank Twajihi Record
	
	String options="";
	
	TableView<Record> table = new TableView<Record>();
	ObservableList<Record> data = FXCollections.observableArrayList(

	);

	@Override
	public void start(Stage primaryStage) {
		try {
			Alert a = new Alert(AlertType.NONE);
			BorderPane root = new BorderPane();
			HBox h = new HBox(30);

			Label l = new Label("Please Select the area ");
			l.setStyle("-fx-text-fill:grey;-fx-font-size:35px");
			h.getChildren().add(l);
			VBox v = new VBox();
			HBox h1 = new HBox(70);
			Button wb = new Button("West Bank");
			wb.setStyle("-fx-background-color:#52796f;-fx-font-size:  20px;");
			
			
			wb.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

					wblist = readFile("src\\WestBank_2019.csv");
					
				
					primaryStage.setScene(branch);

				}
			});

			Button g = new Button("Gaza");
			g.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					wblist = readFile("src\\WestBank_2019.csv");

					
					primaryStage.setScene(branch);
				}
			});
			g.setStyle("-fx-background-color:#52796f;-fx-font-size:  20px;");
			h1.getChildren().addAll(wb, g);
			v.getChildren().addAll(h, h1);
			v.setSpacing(70);
			v.setPadding(new Insets(130, 0, 0, 170));
			root.setCenter(v);
			
			
			Scene scene = new Scene(root, 710, 444);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Home");

			// branch stage
			BorderPane rootb = new BorderPane();
			HBox hb = new HBox(30);

			Label lb = new Label("Please Select the area ");
			lb.setStyle("-fx-text-fill:grey;-fx-font-size:35px");
			hb.getChildren().add(lb);
			VBox vb = new VBox();
			HBox h1b = new HBox(70);
			Button sc = new Button("Scientific");
			sc.setStyle("-fx-background-color:#52796f;-fx-font-size:  20px;");
			sc.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					
					primaryStage.setScene(Home);
				}
			});
			Button lit = new Button("Litreture");
			lit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					
					primaryStage.setScene(Home);
				}
			});
			lit.setStyle("-fx-background-color:#52796f;-fx-font-size:  20px;");
			h1b.getChildren().addAll(sc, lit);
			vb.getChildren().addAll(hb, h1b);
			vb.setSpacing(70);
			vb.setPadding(new Insets(130, 0, 0, 170));
			rootb.setCenter(vb);
			branch = new Scene(rootb, 710, 444);
			branch.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// main form
			VBox nav = new VBox(20);
			// #a44a3f
			Button add = new Button("Insert");
			add.setMaxWidth(Double.MAX_VALUE);
			add.setStyle("-fx-background-color:#a44a3f;-fx-text-fill:#edf2fb");
			
			Button search = new Button("Search");
			search.setStyle("-fx-background-color:#a44a3f;-fx-text-fill:#edf2fb");

			search.setMaxWidth(Double.MAX_VALUE);
			Button top = new Button("Top 10 Students");
			top.setStyle("-fx-background-color:#a44a3f;-fx-text-fill:#edf2fb");
			top.setMaxWidth(Double.MAX_VALUE);
			Button calc = new Button("Calculator");
			calc.setStyle("-fx-background-color:#a44a3f;-fx-text-fill:#edf2fb");
			calc.setMaxWidth(Double.MAX_VALUE);
			Button save = new Button("Save to File");
			save.setMaxWidth(Double.MAX_VALUE);
			save.setStyle("-fx-background-color:#a44a3f;-fx-text-fill:#edf2fb");

			nav.getChildren().addAll(search, add, top, calc, save);
			// Insert scene
			BorderPane addRoot = new BorderPane();
			addRoot.setLeft(nav);
			Label welc = new Label("     Welcome ");
			welc.setPadding(new Insets(0, 30, 10, 170));
			welc.setStyle("-fx-text-fill:grey;-fx-font-size:35px");
			addRoot.setTop(welc);
			addRoot.setPadding(new Insets(50));

			GridPane addGrid = new GridPane();
			addGrid.setHgap(20);
			addGrid.setVgap(20);
			Label seatNumL = new Label("Seat Number:");
			seatNumL.setStyle("-fx-text-fill:#edf2fb;-fx-font-size:15px");
			TextField snt = new TextField();

			snt.setStyle("-fx-background-color:#edf2fb");
			Label avgl = new Label("Average:");
			avgl.setStyle("-fx-text-fill:#edf2fb;-fx-font-size:15px");
			TextField avg = new TextField();
			avg.setStyle("-fx-background-color:#edf2fb");
			Label branchl = new Label("Branch");
			branchl.setStyle("-fx-text-fill:#edf2fb;-fx-font-size:15px");
			TextField branch = new TextField();
			branch.setStyle("-fx-background-color:#edf2fb");
			Button addBtn = new Button("Add");
			addGrid.add(seatNumL, 0, 0);
			addGrid.add(snt, 1, 0);
			addGrid.add(avgl, 0, 1);
			addGrid.add(avg, 1, 1);
			addGrid.add(branchl, 0, 2);
			addGrid.add(branch, 1, 2);
			addGrid.add(addBtn, 1, 3);
			addBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Record data=new Record(Integer.parseInt(snt.getText()),Double.parseDouble(avg.getText()),branch.getText());
					Node node=new Node(data);
					wblist.insertSorted(node);
					Label success=new Label("The Record is added Succesfully");
					success.setStyle("-fx-text-fill:#edf2fb;-fx-font-size:15px");
					addGrid.add(success, 1, 4);
				}});
			addGrid.setPadding(new Insets(20, 0, 0, 90));
			addRoot.setCenter(addGrid);
			Home = new Scene(addRoot, 710, 444);
			Home.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// Search Scene
			BorderPane searchPane = new BorderPane();
			TextField searchTextField = new TextField();
			Button searchDone = new Button("search");
			ChoiceBox searchFilter = new ChoiceBox<>();
			searchFilter.getItems().addAll("Search By Average", "Search by Seat Number");
			HBox searchHBox = new HBox(10);
			searchHBox.setPadding(new Insets(0, 0, 0, 25));
			searchHBox.getChildren().addAll(searchTextField, searchDone, searchFilter);
			searchPane.setTop(searchHBox);
			searchPane.setPadding(new Insets(0, 0, 0, 25));
			search.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Node temp = wblist.first;
					for (int i = 0; i < wblist.listLength; i++) {
						data.add(temp.getData());

						temp = temp.getNext();
					}
					
					addRoot.setCenter(searchPane);
					table.setItems(data);
				}});
			add.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					addRoot.setCenter(addGrid);
				}
			});

			table.setEditable(true);
			TableColumn firstNameCol = new TableColumn("Seat Number");
			firstNameCol.setMinWidth(100);
			firstNameCol.setCellValueFactory(new PropertyValueFactory<Record, Integer>("seatNumber"));

			TableColumn lastNameCol = new TableColumn("Avarage");
			lastNameCol.setMinWidth(100);
			lastNameCol.setCellValueFactory(new PropertyValueFactory<Record, Double>("average"));

			TableColumn emailCol = new TableColumn("Branch");
			emailCol.setMinWidth(200);
			emailCol.setCellValueFactory(new PropertyValueFactory<Record, String>("branch"));

			table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
			TableColumn<Record, Void> colBtn = new TableColumn("Delete");

			Callback<TableColumn<Record, Void>, TableCell<Record, Void>> cellFactory = new Callback<TableColumn<Record, Void>, TableCell<Record, Void>>() {
				@Override
				public TableCell<Record, Void> call(final TableColumn<Record, Void> param) {
					final TableCell<Record, Void> cell = new TableCell<Record, Void>() {

						private final Button btn = new Button("delete");

						{
							btn.setOnAction((ActionEvent event) -> {
							Record record = getTableView().getItems().get(getIndex());
							wblist.remove(record.getSeatNumber());
								data.remove(getTableView().getItems().get(getIndex()));
								table.setItems(data);
							});
						}

						@Override
						public void updateItem(Void item, boolean empty) {
							super.updateItem(item, empty);
							if (empty) {
								setGraphic(null);
							} else {
								setGraphic(btn);
							}
						}
					};
					return cell;
				}
			};

			colBtn.setCellFactory(cellFactory);

			table.getColumns().add(colBtn);

			searchPane.setCenter(table);

			searchDone.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

					if (searchFilter.getValue() == "Search by Seat Number") {
						Node n = wblist.search(Integer.parseInt(searchTextField.getText()));
						
					
						if (n == null) {
							// set alert type
							a.setAlertType(AlertType.ERROR);

							// show the dialog
							a.show();
						} else {
							ObservableList<Record> data2 = FXCollections.observableArrayList(

							);
							data2.add(n.getData());
							table.setItems(data2);
						}
					} else if (searchFilter.getValue() == "Search By Average") {

						ObservableList<Record> data3 = FXCollections.observableArrayList(

						);
						double grade = Double.parseDouble(searchTextField.getText());
						
						int sum = 0;
						
						
						Node temp = wblist.first;
						int size=wblist.listLength;
						// List =new List();
						for (int i = 0; i < size; i++) {
							// System.out.println(temp.getData().getAverage()>=grade);
							if (temp.getData().getAverage() >= grade) {
								sum++;

								data3.add(temp.getData());

							} else {
								break;
							}

							temp = temp.getNext();
						}

						// set alert type
						a.setAlertType(AlertType.INFORMATION);
						double percen = (((double) sum * 100) / (double) size);

						a.setContentText("The percentage =" + percen + "%");
						// show the dialog
						a.show();

						table.setItems(data3);

					}
				}
			});

			calc.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					calculateMMM(wblist);
					standardDeviation = calculateSD(wblist);
					
					GridPane calcPane = new GridPane();
					Label m1 = new Label("The Mean = " + mean);
					m1.setStyle("-fx-text-fill:#edf2fb;-fx-font-size:15px");
					Label m2 = new Label("The Mode = " + mode);
					m2.setStyle("-fx-text-fill:#edf2fb;-fx-font-size:15px");
					Label m3 = new Label("The Median = " + median);
					m3.setStyle("-fx-text-fill:#edf2fb;-fx-font-size:15px");
					Label sd = new Label("Standard Deviation = " + standardDeviation);
					sd.setStyle("-fx-text-fill:#edf2fb;-fx-font-size:15px");

					calcPane.add(m1, 0, 0);
					calcPane.add(m2, 0, 1);
					calcPane.add(m3, 0, 2);
					calcPane.add(sd, 0, 3);

					addRoot.setCenter(calcPane);
				}
			});

			top.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					BorderPane topPane = new BorderPane();
					TableView<Record> table2 = new TableView<Record>();
					table2.setEditable(true);
					TableColumn sn = new TableColumn("Seat Number");
					sn.setMinWidth(100);
					sn.setCellValueFactory(new PropertyValueFactory<Record, Integer>("seatNumber"));

					TableColumn avg = new TableColumn("Avarage");
					avg.setMinWidth(100);
					avg.setCellValueFactory(new PropertyValueFactory<Record, Double>("average"));

					TableColumn branch = new TableColumn("Branch");
					branch.setMinWidth(200);
					branch.setCellValueFactory(new PropertyValueFactory<Record, String>("branch"));

					table2.getColumns().addAll(sn, avg, branch);
					ObservableList<Record> d = FXCollections.observableArrayList(

					);
					
					int size=0;
					Node temp = wblist.first;
					size=wblist.listLength;
					int count = 0;
					for (int i = 0; i < size; i++) {

						if (temp.getData().getAverage() != temp.getNext().getData().getAverage()) {
							count++;
							d.add(temp.getData());

							temp = temp.getNext();
						} else if (temp.getData().getAverage() == temp.getNext().getData().getAverage()) {
							d.add(temp.getData());

							temp = temp.getNext();

						}
						if (count == 10) {
							break;
						}

					}
					
					
					

					table2.setItems(d);
					topPane.setCenter(table2);
					addRoot.setCenter(topPane);
				}

			});

			save.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					DirectoryChooser dir_chooser = new DirectoryChooser();
					// set title
					dir_chooser.setTitle("Select directory");

					// set initial directory
					dir_chooser.setInitialDirectory(new File("c:\\"));

					File file = dir_chooser.showDialog(primaryStage);
					if (file != null) {
						try {
							FileWriter myWriter = new FileWriter(file.getAbsolutePath() + "\\filename.txt");
							myWriter.write("The Mean = " + mean + "\n" + "The Mode = " + mode + "\n" + "The Median = "
									+ median + "\n" + "Standard diviation" + standardDeviation);
							myWriter.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static List readFile(String path) {
		File file = new File(path);
		List list = new List();
		try {
			Scanner in = new Scanner(file);
			while (in.hasNext()) {
				String[] s = in.nextLine().split(",");
				list.insertSorted(new Node(new Record(Integer.parseInt(s[0]), Double.parseDouble(s[2]), s[1])));
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public static void calculateMMM(List list) {
		Node temp = list.first;
		double sum = 0;
		float half = list.listLength / 2;
		int maxCount = 0;
		int count = 0;
		mode = temp.getData().getAverage();
		for (int i = 0; i < list.listLength; i++) {
			sum += temp.getData().getAverage();
			if (temp.getNext() != null)
				if (temp.getData().getAverage() == temp.getNext().getData().getAverage()) {
					count++;
				} else {
					if (maxCount < count) {
						mode = temp.getData().getAverage();
						maxCount = count;
					}
					count = 0;
				}
			if (i == half) {
				if (half % 2 == 0) {
					// even
					median = (temp.getData().getAverage() + temp.getNext().getData().getAverage()) / 2;
				} else {
					// odd
					median = temp.getData().getAverage();
				}
			}
			temp = temp.getNext();
		}
		mean = sum / list.listLength;

	}

	public static double calculateSD(List list) {
		Node temp = list.first;
		double sum = 0;
		for (int i = 0; i < list.listLength; i++) {
			double x = Math.pow((temp.getData().getAverage() - mean), 2);
			sum += x;
			temp = temp.getNext();
		}
		double variance = sum / list.listLength;
		double standard = Math.sqrt(variance);
		return standard;
	}
	

}
