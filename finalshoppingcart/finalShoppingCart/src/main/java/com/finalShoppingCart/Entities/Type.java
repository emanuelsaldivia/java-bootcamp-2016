package com.finalShoppingCart.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value="item type entity",description="types")
public class Type {

	@ApiModelProperty(value="the type Id")
	@Id
	@GeneratedValue
	private int typeId;
	
	@ApiModelProperty(value="the type name")
	private String typeName;
	
	public Type(String typeName){
		this.typeName=typeName;
	}
	
	public int getTypeId(){
		return typeId;
	}
	
	public String getTypeName(){
		return typeName;
	}
	
	public void setTypeName(String typeName){
		this.typeName=typeName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + typeId;
		result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type other = (Type) obj;
		if (typeId != other.typeId)
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

}
