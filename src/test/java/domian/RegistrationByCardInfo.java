package domian;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationByCardInfo {

   private String login;
   private String password;
   private String status;

   public RegistrationByCardInfo(String login, String password) {
      this.login = login;
      this.password = password;
   }
}
