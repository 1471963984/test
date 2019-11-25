package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Second_content;


public interface Second_contentDao {
	public boolean insertSecond_content(Second_content second_content,Connection conn) throws Exception;
	public boolean updateSecond_content(Second_content second_content,Connection conn) throws Exception;
	public boolean deleteSecond_content(int second_num,Connection conn) throws Exception;
	public Second_content selectSecond_content(int second_num,Connection conn) throws Exception;
	public List<Second_content> selectAllSecond_content(Connection conn) throws Exception;
}
