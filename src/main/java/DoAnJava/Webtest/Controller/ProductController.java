package DoAnJava.Webtest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DoAnJava.Webtest.Entity.SAN_PHAM;
import DoAnJava.Webtest.Service.ProductService;

@Controller
@RequestMapping("/san-pham")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/tat-ca-san-pham")
    public String index(Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {
        Page<SAN_PHAM> products = productService.GetAll(page, size);
        model.addAttribute("listproduct", products);
        model.addAttribute("totalPages", products.getTotalPages());
        return "Product/ProductList.html";
    }

    @GetMapping("/thong-tin-san-pham")
    public String infoProduct(Model model, @RequestParam(name = "id") int id) {
        System.out.println("id: " + id);
        model.addAttribute("infoProduct", productService.GetinfoProduct(id));
        return "Product/ProductDetail.html";
    }
}
