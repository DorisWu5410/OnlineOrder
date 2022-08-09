import React from "react";
import { Button, Card, List, message, Select, Tooltip } from "antd";
import { useEffect, useState } from "react";
import { addItemToCart, getMenus, getRestaurants } from "../utils";
import { PlusOutlined } from "@ant-design/icons";

const { Option } = Select

const AddToCartButton = ({itemId}) => {
    const [loading, setLoading] = useState(false)

    const AddToCart = () => {
        setLoading(true)
        addItemToCart(itemId).then(() => {
            message.success("success")
        }).catch((error) => {
            setLoading(false)
        })
    }
    return (
        <Tooltip title="Add to shopping cart">
        <Button
          loading={loading}
          type="primary"
          icon={<PlusOutlined />}
          onClick={AddToCart}
        />
        </Tooltip>
  
    )
}



const FoodList = () => {
// 1. staet for current restarant
// 2. state for the food of selected restarant
// 3. state for loading
// 4. state for all the restarants

const [foodData, setFoodData] = useState([])
const [curRest, setCurRest] = useState()
const [restarants, setRestarants] = useState([])
const [loading, setLoading] = useState(false)
const [loadingRest, setLoadingRest] = useState(false)

useEffect(() => {
    setLoadingRest(true)
    getRestaurants().then(
        (data) => {
            setRestarants(data)
        }
    ).catch((error) => {
        message.error(error.message)
    }).finally(() => {
        setLoadingRest(false)
    })
}, [])

useEffect(() => {
    if (curRest) {
      setLoading(true);
      getMenus(curRest)
        .then((data) => {
          setFoodData(data);
        })
        .catch((err) => {
          message.error(err.message);
        })
        .finally(() => {
          setLoading(false);
        });
    }
  }, [curRest]);


return (
    <>
        <Select
            value = {curRest}
            onSelect = {(value) => setCurRest(value)}
            placeholder = "select a restarant"

        >
            {restarants.map((item) => {
                return <Option key = {item.id} value = {item.id}>{item.name}</Option>;
            })}
        </Select>

        {curRest && (
        <List
          style={{ marginTop: 20 }}
          loading={loading}
          grid={{
            gutter: 16,
            xs: 1,
            sm: 2,
            md: 4,
            lg: 4,
            xl: 3,
            xxl: 3,
          }}
          dataSource={foodData}
          renderItem={(item) => (
            <List.Item>
              <Card
                title={item.name}
                extra={<AddToCartButton itemId={item.id} />}
              >
                <img
                  src={item.imageUrl}
                  alt={item.name}
                  style={{ height: 340, width: "100%", display: "block" }}
                />
                {`Price: ${item.price}`}
              </Card>
            </List.Item>
          )}
        />
      )}
    </>
  );
}



    

export default FoodList