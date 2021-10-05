package com.appgate.sse_test_api.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Process {

    @Id
    private UUID id;
    private Date date;
    private String domainChecked;
    private String similarityDomainsFound;
    private String punycodeDomainsFound;
    @Lob
    private String validatedDomainList;
}
