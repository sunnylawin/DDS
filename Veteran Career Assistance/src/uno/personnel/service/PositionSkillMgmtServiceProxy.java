package uno.personnel.service;

public class PositionSkillMgmtServiceProxy implements uno.personnel.service.PositionSkillMgmtService {
  private String _endpoint = null;
  private uno.personnel.service.PositionSkillMgmtService positionSkillMgmtService = null;
  
  public PositionSkillMgmtServiceProxy() {
    _initPositionSkillMgmtServiceProxy();
  }
  
  public PositionSkillMgmtServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initPositionSkillMgmtServiceProxy();
  }
  
  private void _initPositionSkillMgmtServiceProxy() {
    try {
      positionSkillMgmtService = (new uno.personnel.service.PositionSkilMgmtServiceImplServiceLocator()).getPositionSkillMgmtServicePort();
      if (positionSkillMgmtService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)positionSkillMgmtService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)positionSkillMgmtService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (positionSkillMgmtService != null)
      ((javax.xml.rpc.Stub)positionSkillMgmtService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uno.personnel.service.PositionSkillMgmtService getPositionSkillMgmtService() {
    if (positionSkillMgmtService == null)
      _initPositionSkillMgmtServiceProxy();
    return positionSkillMgmtService;
  }
  
  public java.lang.String addJob(java.lang.String arg0, int arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (positionSkillMgmtService == null)
      _initPositionSkillMgmtServiceProxy();
    return positionSkillMgmtService.addJob(arg0, arg1, arg2);
  }
  
  public java.lang.String addSkill(java.lang.String arg0) throws java.rmi.RemoteException{
    if (positionSkillMgmtService == null)
      _initPositionSkillMgmtServiceProxy();
    return positionSkillMgmtService.addSkill(arg0);
  }
  
  public java.lang.String addJobSkill(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (positionSkillMgmtService == null)
      _initPositionSkillMgmtServiceProxy();
    return positionSkillMgmtService.addJobSkill(arg0, arg1);
  }
  
  public java.lang.String dropJobSkill(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (positionSkillMgmtService == null)
      _initPositionSkillMgmtServiceProxy();
    return positionSkillMgmtService.dropJobSkill(arg0, arg1);
  }
  
  public java.lang.Object[] positionSkill(java.lang.String arg0) throws java.rmi.RemoteException{
    if (positionSkillMgmtService == null)
      _initPositionSkillMgmtServiceProxy();
    return positionSkillMgmtService.positionSkill(arg0);
  }
  
  public java.lang.Object[] possiblePosition(java.lang.String arg0) throws java.rmi.RemoteException{
    if (positionSkillMgmtService == null)
      _initPositionSkillMgmtServiceProxy();
    return positionSkillMgmtService.possiblePosition(arg0);
  }
  
  
}