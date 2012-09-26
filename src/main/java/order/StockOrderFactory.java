package order;

import java.util.HashMap;
import java.util.Map;

public class StockOrderFactory
{
  // protected Map <OrderAction, Map <OrderType, Map <OrderCondition, Map <OrderTimeLimit,
  // StockOrderSpec>>>> specs
  // = new HashMap <OrderAction, Map <OrderType, Map <OrderCondition, Map <OrderTimeLimit,
  // StockOrderSpec>>>> ();

  protected Map<StockOrderSpec, StockOrderSpec> specs =
                                                          new HashMap<StockOrderSpec, StockOrderSpec>();

  public StockOrderSpec getDefaultStockOrder(OrderCondition condition,
                                             OrderTimeLimit timeLimit,
                                             OrderAction action,
                                             OrderType type)
  {
    // if (specs.containsKey(action))
    // {
    // if(specs.get(action).containsKey(type))
    // if(specs.get(action).get(type).containsKey(condition))
    // if(specs.get(action).get(type).get(condition).containsKey(timeLimit))
    // return specs.get(action).get(type).get(condition).get(timeLimit);
    // }
    // return new StockOrderSpec(condition, timeLimit, action, type);
    StockOrderSpec spec = new StockOrderSpec(condition, timeLimit, action, type);
    if (!specs.containsKey(spec))
      specs.put(spec, spec);
    return specs.get(spec);
  }

  public int getTotalCachedStockOrderSpecs()
  {
    return specs.size();
  }
}
