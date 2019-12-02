package service;
import java.util.List;
public interface ShowMyAddrsService{
	public List<String[]> showAddres(String accnum);
	public boolean UpdateDefulAddres(String accnum,int indexx);
}