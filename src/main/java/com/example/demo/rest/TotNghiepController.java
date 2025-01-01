package com.example.demo.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.CongViec;
import com.example.demo.entity.SinhVien;
import com.example.demo.entity.TotNghiep;
import com.example.demo.service.TotNghiepService;

@Controller
@RequestMapping("/totnghiep")
public class TotNghiepController {
	

	private  TotNghiepService totNghiepService;
	
	
	
	@Autowired
	public TotNghiepController(TotNghiepService totNghiepService) {
		super();
		this.totNghiepService = totNghiepService;
	}



//	@GetMapping("/danhsach")
//	public ResponseEntity<List<TotNghiep>> displayDanhSachTotNghiepVaViecLam() {
//	    // Lấy danh sách từ service
//	    List<TotNghiep> listTotNghiep = totNghiepService.getListTotNghiep();
//	    
//	    // Trả về danh sách dưới dạng JSON cùng với status HTTP
//	    return ResponseEntity.ok(listTotNghiep);  // 200 OK
//	}

//	@GetMapping("/danhsach")
//	public String displayDanhSachTotNghiepVaViecLam(Model model) {
//	    // Lấy danh sách từ service
//	    List<TotNghiep> listTotNghiep = totNghiepService.getListTotNghiep();
//	    
//	    
//	    // Thêm danh sách vào model
//	    model.addAttribute("listTotNghiep", listTotNghiep);
//	
//	    
//	    // Trả về view tên "danhsachtotnghiep" để render HTML
//	    return "danhsachtotnghiep";
//	}
	
	@GetMapping("/danhsach")
    public String displayStudent(@RequestParam(value = "search", required = false) String search, Model model) {
		 List<TotNghiep> listTotNghiep;
        
        if (search != null && !search.isEmpty()) {
            // Nếu có tìm kiếm, lọc danh sách sinh viên theo từ khóa
            listTotNghiep = totNghiepService.searchTotNghiep(search);
  
            
        } else {
            // Nếu không có tìm kiếm, lấy tất cả sinh viên
        	listTotNghiep = totNghiepService.getListTotNghiep();
        }
        
        model.addAttribute("listTotNghiep", listTotNghiep);
        model.addAttribute("search", search); // Để giữ lại từ khóa tìm kiếm trong form
        return "danhsachtotnghiep";
    }


}
