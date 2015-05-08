/**
 * CourseInfoVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uno.vendor.service;

public class CourseInfoVO  implements java.io.Serializable {
    private java.lang.String area;

    private java.lang.String courseID;

    private java.lang.String courseTitle;

    private java.lang.String decp;

    private java.lang.String rank;

    private java.lang.String status;

    public CourseInfoVO() {
    }

    public CourseInfoVO(
           java.lang.String area,
           java.lang.String courseID,
           java.lang.String courseTitle,
           java.lang.String decp,
           java.lang.String rank,
           java.lang.String status) {
           this.area = area;
           this.courseID = courseID;
           this.courseTitle = courseTitle;
           this.decp = decp;
           this.rank = rank;
           this.status = status;
    }


    /**
     * Gets the area value for this CourseInfoVO.
     * 
     * @return area
     */
    public java.lang.String getArea() {
        return area;
    }


    /**
     * Sets the area value for this CourseInfoVO.
     * 
     * @param area
     */
    public void setArea(java.lang.String area) {
        this.area = area;
    }


    /**
     * Gets the courseID value for this CourseInfoVO.
     * 
     * @return courseID
     */
    public java.lang.String getCourseID() {
        return courseID;
    }


    /**
     * Sets the courseID value for this CourseInfoVO.
     * 
     * @param courseID
     */
    public void setCourseID(java.lang.String courseID) {
        this.courseID = courseID;
    }


    /**
     * Gets the courseTitle value for this CourseInfoVO.
     * 
     * @return courseTitle
     */
    public java.lang.String getCourseTitle() {
        return courseTitle;
    }


    /**
     * Sets the courseTitle value for this CourseInfoVO.
     * 
     * @param courseTitle
     */
    public void setCourseTitle(java.lang.String courseTitle) {
        this.courseTitle = courseTitle;
    }


    /**
     * Gets the decp value for this CourseInfoVO.
     * 
     * @return decp
     */
    public java.lang.String getDecp() {
        return decp;
    }


    /**
     * Sets the decp value for this CourseInfoVO.
     * 
     * @param decp
     */
    public void setDecp(java.lang.String decp) {
        this.decp = decp;
    }


    /**
     * Gets the rank value for this CourseInfoVO.
     * 
     * @return rank
     */
    public java.lang.String getRank() {
        return rank;
    }


    /**
     * Sets the rank value for this CourseInfoVO.
     * 
     * @param rank
     */
    public void setRank(java.lang.String rank) {
        this.rank = rank;
    }


    /**
     * Gets the status value for this CourseInfoVO.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this CourseInfoVO.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CourseInfoVO)) return false;
        CourseInfoVO other = (CourseInfoVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.area==null && other.getArea()==null) || 
             (this.area!=null &&
              this.area.equals(other.getArea()))) &&
            ((this.courseID==null && other.getCourseID()==null) || 
             (this.courseID!=null &&
              this.courseID.equals(other.getCourseID()))) &&
            ((this.courseTitle==null && other.getCourseTitle()==null) || 
             (this.courseTitle!=null &&
              this.courseTitle.equals(other.getCourseTitle()))) &&
            ((this.decp==null && other.getDecp()==null) || 
             (this.decp!=null &&
              this.decp.equals(other.getDecp()))) &&
            ((this.rank==null && other.getRank()==null) || 
             (this.rank!=null &&
              this.rank.equals(other.getRank()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getArea() != null) {
            _hashCode += getArea().hashCode();
        }
        if (getCourseID() != null) {
            _hashCode += getCourseID().hashCode();
        }
        if (getCourseTitle() != null) {
            _hashCode += getCourseTitle().hashCode();
        }
        if (getDecp() != null) {
            _hashCode += getDecp().hashCode();
        }
        if (getRank() != null) {
            _hashCode += getRank().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CourseInfoVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.vendor.uno/", "courseInfoVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("area");
        elemField.setXmlName(new javax.xml.namespace.QName("", "area"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("courseID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "courseID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("courseTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "courseTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("decp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "decp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rank");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rank"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
