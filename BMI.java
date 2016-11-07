import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class BMI extends JFrame{
	
    private JLabel heightLabel;
    private JSlider heightSlider;
    private JLabel resultBMI;
    private JPanel resultPanel;
    private JPanel sliderPanel;
    private JLabel titleLabel;
    private JLabel weightLabel;
    private JSlider weightSlider;
    private JLabel yourBMILabel;
    
    /**BMI Constructor that calls the initialize() method*/
    public BMI(){
    	initialize();
    }
    
    /**Initializes and arranges all components
     * of the JFrame.*/
    private void initialize(){
    	//Panel to hold weight and height sliders
    	//and height, weight, and title labels.
    	sliderPanel = new JPanel();
    	//Sliders
    	heightSlider = new JSlider();
    	weightSlider = new JSlider();
    	//Labels
    	titleLabel = new JLabel();
    	heightLabel = new JLabel();
    	weightLabel = new JLabel();
    	//Panel to hold the result of BMI conversion.
    	resultPanel = new JPanel();
    	//Label to hold the String "Your BMI:"
    	yourBMILabel = new JLabel();
    	//Label to hold the numerical BMI value
    	resultBMI = new JLabel();
    	
    	//Century Gothic
    	//Comic Sans MS
    	//Consolas
    	//Constantia
    	
        titleLabel.setFont(new Font("Constantia", 1, 13));
        titleLabel.setText("BMI Calculator");
        
    	
    	sliderPanel.setBackground(new Color(204, 204, 255));
    	weightSlider.setBackground(new Color(204, 204, 255));
    	weightSlider.setMajorTickSpacing(40);
        weightSlider.setMaximum(400);
        weightSlider.setMinimum(40);
        weightSlider.setPaintLabels(true);
        weightSlider.setPaintTicks(true);
    	weightSlider.addChangeListener(new javax.swing.event.ChangeListener(){
    		public void stateChanged(javax.swing.event.ChangeEvent evt){
    			weightSliderStateChanged(evt);
    		}
    	});
    	
    	heightSlider.setBackground(new Color(204, 204, 255));
        heightSlider.setMajorTickSpacing(10);
        heightSlider.setMinimum(10);
        heightSlider.setPaintLabels(true);
        heightSlider.setPaintTicks(true);
        heightSlider.addChangeListener(new javax.swing.event.ChangeListener(){
        	public void stateChanged(javax.swing.event.ChangeEvent evt){
        		heightSliderStateChanged(evt);
        	}
        });
    	
        weightLabel.setText("Weight (lbs)");
        
        heightLabel.setText("Height (inches)");
        
        GroupLayout sliderPanelLayout = new GroupLayout(sliderPanel);
        sliderPanel.setLayout(sliderPanelLayout);
        sliderPanelLayout.setHorizontalGroup(
        		sliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(heightSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(weightSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(sliderPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(sliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sliderPanelLayout.createSequentialGroup()
                            .addComponent(heightLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(sliderPanelLayout.createSequentialGroup()
                            .addComponent(weightLabel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                            .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                            .addGap(145, 145, 145))))
        );
        
        sliderPanelLayout.setVerticalGroup(
                sliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(sliderPanelLayout.createSequentialGroup()
                    .addGroup(sliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sliderPanelLayout.createSequentialGroup()
                            .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19))
                        .addComponent(weightLabel, GroupLayout.Alignment.TRAILING))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(weightSlider, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                    .addComponent(heightLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(heightSlider, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
        );
    	
        
        resultPanel.setBackground(new java.awt.Color(255, 255, 0));
        
        yourBMILabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        yourBMILabel.setText("Your BMI:");

        resultBMI.setFont(new java.awt.Font("Tahoma", 1, 11));
        resultBMI.setText("0.0");

        GroupLayout resultPanelLayout = new GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(resultPanelLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(yourBMILabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultBMI)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, resultPanelLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(resultPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(yourBMILabel)
                    .addComponent(resultBMI))
                .addGap(19, 19, 19))
        );
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(sliderPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(resultPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sliderPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        pack();
        
    	setDefaultCloseOperation(EXIT_ON_CLOSE); //ends application once user exits
    }
    
    
    double weight, height, bmi;
    private void weightSliderStateChanged(javax.swing.event.ChangeEvent evt){
    	DecimalFormat df = new DecimalFormat("#.00");
    	weight = weightSlider.getValue();
    	height = heightSlider.getValue();
    	bmi = (weight*703)/(height*height);
        
        resultBMI.setText(df.format(bmi));
    }
    
    
    private void heightSliderStateChanged(javax.swing.event.ChangeEvent evt){
        DecimalFormat df=new DecimalFormat("#.00");
        weight=weightSlider.getValue();
        height=heightSlider.getValue();
        bmi=(weight*703)/(height*height);
        
        resultBMI.setText(df.format(bmi));
    }
	   
    public static void main(String[] args){
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BMI().setVisible(true);
            }
        });
    }
}