package project.dto.filters;

import lombok.Data;

@Data
public class ArticleFilter {

    String searchTitle;
    String searchDinoName;
    int size;
}
