package com.web.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author YXS
 * @PackageName: com.web.entity
 * @ClassName: TableResult
 * @Desription:
 * @date 2023/2/23 9:13
 */
@Data
@Accessors(chain = true)
public class TableResult<T> {

    private List<T> rows;

    private int totalCount;

    private int pageCount;

    public void setPageCount(Integer pageSize) {

        if (pageSize == null) return;
        if (totalCount % pageSize == 0)
            this.pageCount = totalCount / pageSize;
        else
            this.pageCount = totalCount / pageSize + 1;

    }

}
