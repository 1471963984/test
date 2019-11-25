package dao;

import java.sql.Connection;
import java.util.List;

import pojo.First_content;

public interface First_contentDao {
	public boolean insertFirst_content(First_content first_content,Connection conn) throws Exception;
	public boolean updateFirst_content(First_content first_content,Connection conn) throws Exception;
	public boolean deleteFirst_content(int first_num,Connection conn) throws Exception;
	public First_content selectFirst_content(int first_num,Connection conn) throws Exception;
	public List<First_content> selectAllFirst_content(Connection conn) throws Exception;
}
