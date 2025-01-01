package com.example.demo.rest;

import java.sql.Date;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.ReaderEditor;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Nganh;
import com.example.demo.entity.SinhVien;
import com.example.demo.entity.TotNghiep;
import com.example.demo.entity.Truong;
import com.example.demo.service.NganhService;
import com.example.demo.service.SinhVienService;
import com.example.demo.service.TotNghiepService;
import com.example.demo.service.TruongService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/sinhvien")
public class SinhVienController {
	@Autowired
	private SinhVienService sinhVienService;
	
	@Autowired
	private NganhService nganhService;
	
	@Autowired
	private TruongService truongService;
	
	@Autowired
	private TotNghiepService totNghiepService;
	
	
	
	
	
	
	@Autowired
	public SinhVienController(SinhVienService sinhVienService, NganhService nganhService, TruongService truongService,
			TotNghiepService totNghiepService) {
		super();
		this.sinhVienService = sinhVienService;
		this.nganhService = nganhService;
		this.truongService = truongService;
		this.totNghiepService = totNghiepService;
	}

	@GetMapping("/danhsach")
    public String displayStudent(@RequestParam(value = "search", required = false) String search, Model model) {
        List<SinhVien> listSinhVien;
        
        if (search != null && !search.isEmpty()) {
            // Nếu có tìm kiếm, lọc danh sách sinh viên theo từ khóa
            listSinhVien = sinhVienService.searchSinhVien(search);
        } else {
            // Nếu không có tìm kiếm, lấy tất cả sinh viên
            listSinhVien = sinhVienService.getListSinhVien();
        }
        
        model.addAttribute("listSinhVien", listSinhVien);
        model.addAttribute("search", search); // Để giữ lại từ khóa tìm kiếm trong form
        return "danhsachsinhvien";
    }
	
//	@GetMapping("/danhsachtotnghiep")
//	public String displayDanhSachTotNghiepVaViecLam(Model model) {
//	    // Lấy danh sách từ service
//	    List<TotNghiep> listSinhVienTotNghiep = totnghiep.getListSinhVienTotNghiep();
//	    
//	    // Thêm danh sách vào model
//	    model.addAttribute("listSinhVienTotNghiep", listSinhVienTotNghiep);
//	    
//	    // Trả về view tên "danhsachtotnghiep" để render HTML
//	    return "danhsachtotnghiep";
//	}


	@GetMapping("/themsinhvien")
	public String addStudent(Model model) {
		model.addAttribute("SinhVien",new SinhVien());
		model.addAttribute("TotNghiep",new TotNghiep());
		
		
		List<Truong> listTruong = truongService.getListTruong() ;
		
		model.addAttribute("Truong",listTruong);
		
		List<Nganh> listNganh = nganhService.getListNganh();
		model.addAttribute("Nganh",listNganh);
		
		
		return "themsinhvien";
	}
	
	
	@PostMapping("/themsinhvien")
	public String addStudentPost(@ModelAttribute("SinhVien") SinhVien sv, @ModelAttribute("TotNghiep") TotNghiep tn, RedirectAttributes redirectAttributes) {

	    
		Date ngayTnDate = tn.getNgayTotNghiep();  
		// Kiểm tra nếu ngày tốt nghiệp là null
		if (ngayTnDate != null) {
		    java.util.Date utilDate = new java.util.Date(ngayTnDate.getTime());

		    LocalDate ngayTn = utilDate.toInstant()  
		                                 .atZone(ZoneId.systemDefault())  
		                                 .toLocalDate();  
			if (ngayTn.isAfter(LocalDate.now())) {
			redirectAttributes.addFlashAttribute("error", "Ngày tốt nghiệp phải trước thời gian hiện tại!");
			return "redirect:/sinhvien/themsinhvien";
			}
		}
	    
	    sinhVienService.addSinhVienTotNghiep(sv, tn);
	   
	    
	    // Thêm thông báo thành công vào model
	    redirectAttributes.addFlashAttribute("message", "Thêm sinh viên tốt nghiệp thành công!");

	    // Chuyển hướng về trang danh sách sinh viên hoặc một trang khác sau khi thêm thành công
	    return "redirect:/sinhvien/danhsach";
	}
	
	@GetMapping("/capnhat")
	public String capNhatSinhVien(@RequestParam("soCMND") String soCMND, Model model) {
		
		SinhVien sv = sinhVienService.getSinhVienByCMND(soCMND);
		
		model.addAttribute("SinhVien", sv);
		
		return "capnhatsinhvien";
	}
	
	@PostMapping("/capnhat")
	public String capNhatSinhVienPost(@RequestParam("soCMND") String soCMND,@ModelAttribute("SinhVien") SinhVien sinhvien, RedirectAttributes redirectAttributes) {
		
		SinhVien sv = sinhVienService.getSinhVienByCMND(soCMND);
		
		if(sv == null) {
			redirectAttributes.addFlashAttribute("error", "Sinh viên không tồn tại");
			return "redirect:/sinhvien/capnhatsinhvien";
			
		}
		
		sinhVienService.capNhatSinhVien(sinhvien);
		redirectAttributes.addFlashAttribute("message", "Cập nhạt sinh viên thành công");
		
		return "redirect:/sinhvien/danhsach";
	}
	
	@GetMapping("/xoa")
	public String deleteStudent(@RequestParam("soCMND")String soCMND,RedirectAttributes redirectAttributes) {
		
		
		SinhVien sv = sinhVienService.getSinhVienByCMND(soCMND);
		
		if(sv == null) {
			redirectAttributes.addFlashAttribute("error", "Sinh viên không tồn tại");
			return "redirect:/sinhvien/danhsach";
			
		}
		sinhVienService.xoaSinhVien(soCMND);
		redirectAttributes.addFlashAttribute("message","Xóa sinh viên thành công");
	
		return "redirect:/sinhvien/danhsach";
	}
	
	@GetMapping("/chitiet")
	public String chitietSinhVien(@RequestParam("soCMND")String soCMND,RedirectAttributes redirectAttributes) {
		
		SinhVien sv = sinhVienService.getSinhVienByCMND(soCMND);
		
		if(sv == null) {
			redirectAttributes.addFlashAttribute("error", "Sinh viên không tồn tại");
			return "redirect:/sinhvien/danhsach";
			
		}
		sinhVienService.xoaSinhVien(soCMND);
		redirectAttributes.addFlashAttribute("message","Xóa sinh viên thành công");
	
		return "redirect:/sinhvien/danhsach";
	}
	


}
