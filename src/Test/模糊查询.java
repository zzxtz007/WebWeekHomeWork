package Test;

import top.haha233.DAO.DAOFactory;
import top.haha233.entity.Score;

import java.util.ArrayList;

public class 模糊查询
{
	public static void main(String[] args)
	{
		ArrayList<Score> arrayList = DAOFactory.getScoreDao(DAOFactory.MYSQL).queryAll();
		System.out.println(arrayList);
	}
}
