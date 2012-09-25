package order;

import java.util.HashMap;
import java.util.Map;

public class StockOrderSpec
{
  protected OrderCondition condition;
  protected OrderTimeLimit limit;
  protected OrderAction    action;
  protected OrderType      type;

  protected StockOrderSpec(OrderCondition condition,
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
  
	@Override
public String toString() {
	return "StockOrderSpec [condition=" + condition + ", limit=" + limit
			+ ", action=" + action + ", type=" + type + "]";
}

	@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((action == null) ? 0 : action.hashCode());
	result = prime * result + ((condition == null) ? 0 : condition.hashCode());
	result = prime * result + ((limit == null) ? 0 : limit.hashCode());
	result = prime * result + ((type == null) ? 0 : type.hashCode());
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
	StockOrderSpec other = (StockOrderSpec) obj;
	if (action != other.action)
		return false;
	if (condition != other.condition)
		return false;
	if (limit != other.limit)
		return false;
	if (type != other.type)
		return false;
	return true;
}

	protected static Map <StockOrderSpec, StockOrderSpec> specs = new HashMap <StockOrderSpec, StockOrderSpec> ();
	public static StockOrderSpec newInstance(OrderCondition condition,
			OrderTimeLimit timeLimit,
			OrderAction action,
			OrderType type)
	{
		StockOrderSpec spec = new StockOrderSpec(condition, timeLimit, action, type);
		if (!specs.containsKey(spec))
			specs.put(spec, spec);
		return specs.get(spec);
	}

	public static int getTotalCachedStockOrderSpecInstances()
	{
		return specs.size();
	}
	
	public static void main(String [] args)
	{
		StockOrderSpec spec = StockOrderSpec.newInstance(OrderCondition.ALL_OR_NONE, 
				OrderTimeLimit.DAY, 
				OrderAction.BUY, 
				OrderType.LIMIT_ORDER);
		StockOrderSpec spec2 = StockOrderSpec.newInstance(OrderCondition.ALL_OR_NONE, 
				OrderTimeLimit.DAY, 
				OrderAction.BUY, 
				OrderType.LIMIT_ORDER);
		System.out.println(spec);
		System.out.println(spec2);
		System.out.println(StockOrderSpec.getTotalCachedStockOrderSpecInstances());
	}
}
