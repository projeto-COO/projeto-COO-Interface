package GraphicInterface;

import java.awt.EventQueue;
import java.util.List;
import java.util.Map;

import MoviesData.HistoricData;
import MoviesData.MovieData;
import MoviesData.RoomData;
import MoviesData.SessionData;
import Startup.StartupSystem;
import System.HistoricFactory;

public class StartupGraphicInterface extends StartupSystem {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		downloadData();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGraphUserInterf main = new MainGraphUserInterf();
					main.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
