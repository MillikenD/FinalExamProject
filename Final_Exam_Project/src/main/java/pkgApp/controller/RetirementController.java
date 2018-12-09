package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;
import java.lang.Math;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField txtAnnualReturnWorking;
	
	@FXML
	private TextField txtYearsRetired;
	
	@FXML
	private TextField txtAnnualReturnRetired;
	
	@FXML
	private TextField txtRequiredIncome;
	
	@FXML
	private TextField txtMonthlySSI;
	
	@FXML
	private Label lSaveEachMonth;
	
	@FXML
	private Label lToSave;
	

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		txtYearsToWork.setText("");
		txtAnnualReturnWorking.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturnRetired.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
		lSaveEachMonth.setText("");
		lToSave.setText("");
		
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		Retirement rt = new Retirement();
		
		rt.setiYearsToWork(Integer.parseInt(txtYearsToWork.getText()));
		rt.setdAnnualReturnWorking(Double.parseDouble(txtAnnualReturnWorking.getText()));
		rt.setiYearsRetired(Integer.parseInt(txtYearsRetired.getText()));
		rt.setdAnnualReturnRetired(Double.parseDouble(txtAnnualReturnRetired.getText()));
		rt.setdRequiredIncome(Double.parseDouble(txtRequiredIncome.getText()));
		rt.setdMonthlySSI(Double.parseDouble(txtMonthlySSI.getText()));
		
		Double ATS = rt.AmountToSave();
		Double TAS = Math.abs(rt.TotalAmountSaved());
		
		ATS = (double) Math.round(100*ATS)/100;
		TAS = (double) Math.round(100*TAS)/100;
		
		lSaveEachMonth.setText(Double.toString(ATS));
		lToSave.setText(Double.toString(TAS));
		
		
		
	}
	
}
