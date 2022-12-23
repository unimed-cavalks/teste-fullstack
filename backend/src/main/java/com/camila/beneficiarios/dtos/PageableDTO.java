package com.camila.beneficiarios.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonInclude( JsonInclude.Include.NON_NULL )
@NoArgsConstructor
@AllArgsConstructor
public class PageableDTO {

    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final int DEFAULT_PAGE_INDEX = 0;
    private static final String DEFAULT_SORT_DIRECTION = "ASC";
    private static final String SORT_FIELD_DEFAULT = "id";

    @Builder.Default
    @ApiModelProperty( value = "10", notes = "Default value 10" )
    private int pageSize = DEFAULT_PAGE_SIZE;

    @Builder.Default
    @ApiModelProperty( value = "0", notes = "Default value 0" )
    private int pageNumber = DEFAULT_PAGE_INDEX;

    @Builder.Default
    @ApiModelProperty( value = DEFAULT_SORT_DIRECTION, notes = "Default value ASC" )
    private String sortDirection = DEFAULT_SORT_DIRECTION;

    @Builder.Default
    @ApiModelProperty( value = SORT_FIELD_DEFAULT, notes = "Default value status" )
    private String sortField = SORT_FIELD_DEFAULT;
}
