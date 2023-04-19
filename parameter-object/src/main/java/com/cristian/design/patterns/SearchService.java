package com.cristian.design.patterns;

public class SearchService {

  /**
   * Below two methods of name `search` is overloaded so that we can send a default value for one of the criteria and call the final api. A
   * default SortOrder is sent in the first method and a default SortBy is sent in the second method. So two separate method definitions are
   * needed for having default values for one argument in each case. Hence multiple overloaded methods are needed as the number of argument
   * increases.
   */
  public String search(String type, String sortBy) {
    return querySummary(type, sortBy, SortOrder.ASC);
  }

  public String search(String type, SortOrder sortOrder) {
    return querySummary(type, "price", sortOrder);
  }

  /**
   * The need for multiple method definitions can be avoided by the Parameter Object pattern. Below is the example where only one method is
   * required and all the logic for having default values are abstracted into the Parameter Object at the time of object creation.
   */
  public String search(final ParameterObject parameterObject) {
    return querySummary(parameterObject.getType(), parameterObject.getSortBy(),
        parameterObject.getSortOrder());
  }

  private String querySummary(final String type, final String sortBy, final SortOrder sortOrder) {
    return String.format("Requesting shoes of type \"%s\" sorted by \"%s\" in \"%sending\" order..",
        type,
        sortBy,
        sortOrder.name());
  }

  public static final class ParameterObject {

    public static final String DEFAULT_SORT_BY = "price";

    public static final SortOrder DEFAULT_SORT_ORDER = SortOrder.ASC;

    private String type;

    private String sortBy;

    private SortOrder sortOrder;

    private ParameterObject(final Builder builder) {
      setType(builder.type);
      setSortBy(builder.sortBy);
      setSortOrder(builder.sortOrder);
    }

    public static Builder builder() {
      return new Builder();
    }

    public String getType() {
      return this.type;
    }

    public void setType(final String type) {
      this.type = type;
    }

    public String getSortBy() {
      return this.sortBy;
    }

    public void setSortBy(final String sortBy) {
      this.sortBy = sortBy;
    }

    public SortOrder getSortOrder() {
      return this.sortOrder;
    }

    public void setSortOrder(final SortOrder sortOrder) {
      this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
      return String.format("ParameterObject[type='%s', sortBy='%s', sortOrder='%s']", this.type, this.sortBy, this.sortOrder);
    }

    public static final class Builder {

      private String type;

      private String sortBy = DEFAULT_SORT_BY;

      private SortOrder sortOrder = DEFAULT_SORT_ORDER;

      private Builder() {
      }

      public Builder withType(String type) {
        this.type = type;
        return this;
      }

      public Builder sortBy(String sortBy) {
        this.sortBy = sortBy;
        return this;
      }

      public Builder sortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
        return this;
      }

      public ParameterObject build() {
        return new ParameterObject(this);
      }
    }
  }
}
