package com.example.demo.dto.request;

import java.io.Serializable;
import java.util.List;

public class EstatesIdsRequst implements Serializable {
    List<Long> estates_ids;

    public List<Long> getEstates_ids() {
        return estates_ids;
    }

    public void setEstates_ids(List<Long> estates_ids) {
        this.estates_ids = estates_ids;
    }
}
