import java.util.List;

import model.DeptDAO;
import model.DeptDTO;

public class Ex1 {
	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
		List<DeptDTO> list = dao.getDeptList();
		for(DeptDTO dto : list) {
			System.out.println(dto);
		}
	}
}
