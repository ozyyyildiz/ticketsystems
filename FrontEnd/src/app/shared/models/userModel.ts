import {UserRoleModel} from "./userRoleModel";

export class UserModel{

  constructor(public userName: string,
              public email: string,
              public password: string,
              public userRole: string,
              public id?: string) {
  }
}
