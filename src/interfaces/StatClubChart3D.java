/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import DAO.StatClubDAO;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import utils.DataSource;

/**
 *
 * @author Rym
 */
public class StatClubChart3D extends ApplicationFrame {
    public StatClubChart3D(final String title) throws IOException {

        super(title);

        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(400,400));
        setContentPane(chartPanel);

    }
    private CategoryDataset createDataset() throws  IOException {

                // 0. Création d'un diagramme.
         // DefaultCategoryDataset dataset = new DefaultCategoryDataset();
          DefaultCategoryDataset dataset = new DefaultCategoryDataset();
   
          DataSource con=new DataSource();
       


      
StatClubDAO s = new StatClubDAO();
 dataset.setValue(s.countClubParNordDuPays(), "Nord", "Nord");
 dataset.setValue(s.countClubParCentreDuPays(), "Centre", "Centre");
 dataset.setValue(s.countClubParSudDuPays(), "Sud", "Sud");

        return dataset;

    }
    private JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createBarChart3D(
            " la repartition des clubs  par section ",      // chart title
            " ",               // domain axis label
            "  Le nombre des club ",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips
            true                     // urls
        );

        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI /2.0)
        );

//        final CategoryItemRenderer renderer = plot.getRenderer();
//        renderer.setItemLabelsVisible(true);
//        final BarRenderer r = (BarRenderer) renderer;
 
    

        return chart;

    }

   
    public static void main(final String[] args) throws IOException {

        final StatClubChart3D demo = new StatClubChart3D("statistiques ");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}
    

