package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AD")
public class Admin extends User {

  private void ableUser(FinalUser user) {
  }

  private void disableUser(FinalUser user) {
  }

  private void newActivity() {
  }

  private void editActivity(Activity activity, String name) {
  }

  private void deleteActivity(Activity activity) {
  }

  private void ableActivity(Activity activity) {
  }

  private void disableActivity(Activity activity) {
  }

}