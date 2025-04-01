package jay.net.masterjsfapp.controller;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class AdminDashboardBean implements Serializable {

    private int totalUsers = 120;
    private int pendingVerifications = 5;
    private int totalLogs = 350;

    private BarChartModel userChart;
    private PieChartModel activityChart;

    public AdminDashboardBean() {
        createUserChart();
        createActivityChart();
    }

    public int getTotalUsers() {
        return totalUsers;
    }

    public int getPendingVerifications() {
        return pendingVerifications;
    }

    public int getTotalLogs() {
        return totalLogs;
    }

    public BarChartModel getUserChart() {
        return userChart;
    }

    public PieChartModel getActivityChart() {
        return activityChart;
    }

    private void createUserChart() {
        userChart = new BarChartModel();
        ChartSeries users = new ChartSeries();
        users.setLabel("Users");

        users.set("January", 20);
        users.set("February", 30);
        users.set("March", 50);
        users.set("April", 70);
        users.set("May", 120);

        userChart.addSeries(users);
        userChart.setTitle("User Growth");
        userChart.setLegendPosition("ne");
    }

    private void createActivityChart() {
        activityChart = new PieChartModel();
        activityChart.set("Logins", 200);
        activityChart.set("Registrations", 50);
        activityChart.set("Password Resets", 30);
        activityChart.setTitle("System Activity");
        activityChart.setLegendPosition("w");
    }
}
