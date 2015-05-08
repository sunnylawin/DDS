/**
 * TrainingCounselingServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uno.mgmt.service;

public class TrainingCounselingServiceImplServiceLocator extends org.apache.axis.client.Service implements uno.mgmt.service.TrainingCounselingServiceImplService {

    public TrainingCounselingServiceImplServiceLocator() {
    }


    public TrainingCounselingServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TrainingCounselingServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TrainingCounselingServicePort
    private java.lang.String TrainingCounselingServicePort_address = "http://localhost:8080/Training_Counseling_service/TrainingCounselingServiceImplService";

    public java.lang.String getTrainingCounselingServicePortAddress() {
        return TrainingCounselingServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TrainingCounselingServicePortWSDDServiceName = "TrainingCounselingServicePort";

    public java.lang.String getTrainingCounselingServicePortWSDDServiceName() {
        return TrainingCounselingServicePortWSDDServiceName;
    }

    public void setTrainingCounselingServicePortWSDDServiceName(java.lang.String name) {
        TrainingCounselingServicePortWSDDServiceName = name;
    }

    public uno.mgmt.service.TrainingCounselingService getTrainingCounselingServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TrainingCounselingServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTrainingCounselingServicePort(endpoint);
    }

    public uno.mgmt.service.TrainingCounselingService getTrainingCounselingServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uno.mgmt.service.TrainingCounselingServicePortBindingStub _stub = new uno.mgmt.service.TrainingCounselingServicePortBindingStub(portAddress, this);
            _stub.setPortName(getTrainingCounselingServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTrainingCounselingServicePortEndpointAddress(java.lang.String address) {
        TrainingCounselingServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uno.mgmt.service.TrainingCounselingService.class.isAssignableFrom(serviceEndpointInterface)) {
                uno.mgmt.service.TrainingCounselingServicePortBindingStub _stub = new uno.mgmt.service.TrainingCounselingServicePortBindingStub(new java.net.URL(TrainingCounselingServicePort_address), this);
                _stub.setPortName(getTrainingCounselingServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TrainingCounselingServicePort".equals(inputPortName)) {
            return getTrainingCounselingServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.mgmt.uno/", "TrainingCounselingServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.mgmt.uno/", "TrainingCounselingServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TrainingCounselingServicePort".equals(portName)) {
            setTrainingCounselingServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
