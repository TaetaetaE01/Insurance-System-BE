package fourservings_fiveservings.insurance_system_be.team.product.service;

import fourservings_fiveservings.insurance_system_be.domain.user.entity.User;
import fourservings_fiveservings.insurance_system_be.team.product.dto.DesignProductRequestDto;
import fourservings_fiveservings.insurance_system_be.team.product.entity.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import fourservings_fiveservings.insurance_system_be.team.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void designProduct(User productDeveloper,
                              DesignProductRequestDto designProductRequestDto) {
        Product product = designProductRequestDto.toProduct(productDeveloper);
        productRepository.save(product);
    }

    public List<Product> retrieveUnapprovedProducts() {
        List<Product> unapprovedProducts = productRepository.findByApproveStatus(
                ApproveStatus.UN_APPROVE);
        return unapprovedProducts;
    }

    public List<Product> retrieveApprovedProducts() {
        List<Product> approvedProducts = productRepository.findByApproveStatus(
                ApproveStatus.APPROVE);
        return approvedProducts;
    }
}
