package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Second_content;


public interface Second_contentDao {
	public boolean insertSecond_content(Second_content second_content,Connection conn);
	public boolean updateSecond_content(Second_content second_content,Connection conn);
	public boolean deleteSecond_content(int second_num,Connection conn);
	public Second_content selectSecond_content(int second_num,Connection conn);
	public List<Second_content> selectAllSecond_content(Connection conn);
}
