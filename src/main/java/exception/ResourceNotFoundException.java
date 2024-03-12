package exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException {
  String resourceName;
  String feildName;
  long feildvalue;
  public ResourceNotFoundException(String resourceName,String feildName,long feildvalue)
  {
      super();
            this.resourceName=resourceName;
            this.feildName=feildName;
            this.feildvalue=feildvalue;

  }


}
