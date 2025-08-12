package test;

import java.util.List;

import dao.TinyDAO;
import dto.TinyDTO;

public class TinyDAOEx {

	public static void main(String[] args) {
		TinyDAO dao = new TinyDAO();
		
		dao.insertOne(new TinyDTO(0, "사랑합니다"));
		
		List<TinyDTO> list = dao.selectList();
		for (TinyDTO dto : list) {
			System.out.println(dto);
		}

	}

}
