package order;

public class StockOrderSpec
{
  protected OrderCondition condition;
  protected OrderTimeLimit limit;
  protected OrderAction    action;
  protected OrderType      type;

  public StockOrderSpec(OrderCondition condition,
                        OrderTimeLimit limit,
                        OrderAction action,
                        OrderType type)
  {
    this.condition = condition;
    this.limit = limit;
    this.action = action;
    this.type = type;
  }

  public OrderCondition getCondition()
  {
    return condition;
  }

  public void setCondition(OrderCondition condition)
  {
    this.condition = condition;
  }

  public OrderTimeLimit getLimit()
  {
    return limit;
  }

  public void setLimit(OrderTimeLimit limit)
  {
    this.limit = limit;
  }

  public OrderAction getAction()
  {
    return action;
  }

  public void setAction(OrderAction action)
  {
    this.action = action;
  }

  public OrderType getType()
  {
    return type;
  }

  public void setType(OrderType type)
  {
    this.type = type;
  }
}
