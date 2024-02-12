package org.jsp.crud._rest.helper;



import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ResponseStructure<T> {
   String message;
   int status;
   T data;
}
