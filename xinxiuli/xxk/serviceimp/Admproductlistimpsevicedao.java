package serviceimp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.imp.Admproductlistimp;
import db.DbHelp;
import dto.Admproductlist;
import service.Admproductlistimpsevice;

public class Admproductlistimpsevicedao implements Admproductlistimpsevice{

	@Override
	public List<Admproductlist> selectadmlist(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<Admproductlist> list=null;
        Connection  conn=DbHelp.getConnection();
        Admproductlistimp  admdao=new Admproductlistimp();      
        try {
			list= admdao.selectadm(pageNo, pageSize, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
		 DbHelp.closeConnection(conn);	
		}
		return list;
	}

	@Override
	public Admproductlist selectadmbyid(int goods_num)  {
		Admproductlist adm=null;
		Connection  conn=DbHelp.getConnection();
        Admproductlistimp  admdao=new Admproductlistimp();
            try {
				adm  =admdao.selectadmbyid(goods_num, conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}finally {
				DbHelp.closeConnection(conn);
			}
		return adm;
	}

	@Override
	public int selectMaxPageNo(int pageSize) {
		int count=0;
		Connection  conn=DbHelp.getConnection();
        Admproductlistimp  admdao=new Admproductlistimp();
		                  
        try {
			  count=admdao.selectMaxPageNo(pageSize, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
		DbHelp.closeConnection(conn);
		}

        return count;
	}

}
