package uno.mgmt.service;

public class TrainingCounselingServiceProxy implements uno.mgmt.service.TrainingCounselingService {
  private String _endpoint = null;
  private uno.mgmt.service.TrainingCounselingService trainingCounselingService = null;
  
  public TrainingCounselingServiceProxy() {
    _initTrainingCounselingServiceProxy();
  }
  
  public TrainingCounselingServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initTrainingCounselingServiceProxy();
  }
  
  private void _initTrainingCounselingServiceProxy() {
    try {
      trainingCounselingService = (new uno.mgmt.service.TrainingCounselingServiceImplServiceLocator()).getTrainingCounselingServicePort();
      if (trainingCounselingService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)trainingCounselingService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)trainingCounselingService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (trainingCounselingService != null)
      ((javax.xml.rpc.Stub)trainingCounselingService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uno.mgmt.service.TrainingCounselingService getTrainingCounselingService() {
    if (trainingCounselingService == null)
      _initTrainingCounselingServiceProxy();
    return trainingCounselingService;
  }
  
  public java.lang.Object[] missingSkill(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (trainingCounselingService == null)
      _initTrainingCounselingServiceProxy();
    return trainingCounselingService.missingSkill(arg0, arg1);
  }
  
  public java.lang.Object[] recommendCourse(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (trainingCounselingService == null)
      _initTrainingCounselingServiceProxy();
    return trainingCounselingService.recommendCourse(arg0, arg1);
  }
  
  
}