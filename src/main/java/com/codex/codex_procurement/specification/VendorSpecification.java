package com.codex.codex_procurement.specification;

import com.codex.codex_procurement.dto.request.SearchVendorRequest;
import com.codex.codex_procurement.entity.Vendor;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class VendorSpecification {
    public static Specification<Vendor> getSpecification (SearchVendorRequest request) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (request.getName() != null) {
                predicates.add(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%"+request.getName().toLowerCase()+"%")
                );
            }
            return query.where(predicates.toArray(new Predicate[]{})).getRestriction();
        };
    }
}
